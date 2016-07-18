package com.vodafone.er.ecom.proxy;

import com.vodafone.application.util.Pair;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    private static List<Method> getGetters(Class<?> clazz)	{
        final List<Method> methods =  new ArrayList<>();
        for (final Method method : clazz.getMethods()) {
            if (method.getParameterTypes().length==0 && !method.getReturnType().equals(Void.class) &&
                    (method.getName().startsWith("get") ||  method.getName().startsWith("is")) &&
                    Modifier.isPublic(method.getModifiers()) &&
                    !(method.getName().equals("isEmpty") || method.getName().equals("getBytes")))	{	//filter out String methods

                methods.add(method);

            }
        }
        return methods;

    }

    private static List<Pair<String, Object>> getValues(Object toBeTested) throws Exception	{
        List<Pair<String, Object>> results = new ArrayList<>();
        List<Method> methods = getGetters(toBeTested.getClass());
        for (Method m: methods)	{
            Object result = m.invoke(toBeTested, new Object[]{});
            results.add(Pair.of(m.getName(), result));
        }
        return results;
    }


    public static void generateTestCode(Object toBeTested, String objectName) throws Exception	{

        for (Pair<String, Object>  p: getValues(toBeTested))	{
            Object result = p.getValue();
            String methodName= p.getKey();
            if (result == null)
                System.out.println("assertNull(\""+objectName+"."+ methodName+"() should be null\", "+objectName+"."+methodName+"());");
            else if (result instanceof Integer )	{
                System.out.println("assertEquals(\""+objectName+"."+ methodName+"()\", "+result+", "+objectName+"."+ methodName+"());");
            }	else if (result instanceof Double )	{
                System.out.println("assertEquals(\""+objectName+"."+ methodName+"()\", new Double("+result+"), new Double("+objectName+"."+ methodName+"()));");
            }	else if (result instanceof Long )	{
                System.out.println("assertEquals(\""+objectName+"."+ methodName+"()\", new Long("+result+"), new Long("+objectName+"."+ methodName+"()));");}	else if (result instanceof Boolean)	{
                Boolean bool = (Boolean)result;
                if (bool)	{
                    System.out.println("assertTrue(\""+objectName+"."+ methodName+"() should return true\", "+objectName+"."+ methodName+"());");
                }	else	{
                    System.out.println("assertFalse(\""+objectName+"."+ methodName+"() should return false\", "+objectName+"."+ methodName+"());");
                }
            } else if (result instanceof Class)	{
                //do nothing
            } else if (result instanceof Object[])	{
                Object[] array = (Object[]) result;
                for (int i=0 ; i<array.length; i++)	{
//					//loop through each object
//					//for each object get the methods, invoke them, get the values etc
                    generateTestCode(array[i], objectName+"."+methodName+"()["+i+"]");
                    i++;
                }
            } else if (result instanceof List)	{
                int i=0;
                for (Object pp: (List)result)	{
//					//loop through each object
//					//for each object get the methods, invoke them, get the values etc
                    generateTestCode(pp, objectName+"."+methodName+"().get("+i+")");
                    i++;
                }
            }	else if (result instanceof String)	{
                System.out.println("assertEquals(\""+objectName+"."+ methodName+"()\", \""+result+"\", "+objectName+"."+ methodName+"());");
            }	else	{
                System.out.println("// "+result.getClass().getName());
//				System.out.println("assertEquals(\""+objectName+"."+ methodName+"()\", \""+result+"\", "+objectName+"."+ methodName+"().toString());");
            }

        }

    }

    public static void generateAssertJTestCode(Object toBeTested, String objectName) throws Exception {
        for (Pair<String, Object>  p: getValues(toBeTested))	{
            Object result = p.getValue();
            String methodName= p.getKey();
            if (result == null) {
                System.out.println("softly.assertThat(" + objectName + "." + methodName + "() ).as(\" " + objectName + "." + methodName + "()\" )"
                        + ".isNull();");
            }
            else if (result instanceof Integer )	{
                System.out.println("softly.assertThat(" + objectName + "." + methodName + "() ).as(\" " + objectName + "." + methodName + "()\" )"
                        + ".isEqualTo("+ result +") ;");
            }	else if (result instanceof Double )	{
                System.out.println("softly.assertThat(" + objectName + "." + methodName + "() ).as(\" " + objectName + "." + methodName + "()\" )"
                        + ".isEqualTo(new Double("+ result +")) ;");
            }	else if (result instanceof Long )	{
                System.out.println("softly.assertThat(" + objectName + "." + methodName + "() ).as(\" " + objectName + "." + methodName + "()\" )"
                        + ".isEqualTo(new Long("+ result +")) ;");
            }
            else if (result instanceof Boolean)	{

                Boolean bool = (Boolean)result;
                if (bool)	{
//                    System.out.println("assertTrue(\""+objectName+"."+ methodName+"() should return true\", "+objectName+"."+ methodName+"());");
                    System.out.println("softly.assertThat(" + objectName + "." + methodName + "() ).as(\" " + objectName + "." + methodName + "()\" )"
                            + ".isTrue() ;");
                }	else	{
//                    System.out.println("assertFalse(\""+objectName+"."+ methodName+"() should return false\", "+objectName+"."+ methodName+"());");
                    System.out.println("softly.assertThat(" + objectName + "." + methodName + "() ).as(\" " + objectName + "." + methodName + "()\" )"
                            + ".isFalse() ;");
                }
            }
            else if (result instanceof Class)	{
                //do nothing
            }
            else if (result instanceof Object[])	{
                Object[] array = (Object[]) result;
                for (int i=0 ; i<array.length; i++)	{
//					//loop through each object
//					//for each object get the methods, invoke them, get the values etc
                    generateAssertJTestCode(array[i], objectName+"."+methodName+"()["+i+"]");
                    i++;
                }
            }
            else if (result instanceof List)	{
                int i=0;
                for (Object pp: (List)result)	{
//					//loop through each object
//					//for each object get the methods, invoke them, get the values etc
                    generateAssertJTestCode(pp, objectName+"."+methodName+"().get("+i+")");
                    i++;
                }
            } else if (result instanceof String) {

                //Current assumption is null and empty string are equivalent
                if(result == null || ((String) result).isEmpty()) {
                    System.out.println("softly.assertThat(" + objectName + "." + methodName + "() ).as(\" " + objectName + "." + methodName + "()\" )"
                            + ".isNullOrEmpty();");
                }

                System.out.println("softly.assertThat(" + objectName + "." + methodName + "() ).as(\" " + objectName + "." + methodName + "()\" )"
                        + ".isEqualTo(\"" + result +"\");");
            } else	{
                System.out.println("// "+result.getClass().getName());
//				System.out.println("assertEquals(\""+objectName+"."+ methodName+"()\", \""+result+"\", "+objectName+"."+ methodName+"().toString());");
            }

        }


    }
}
