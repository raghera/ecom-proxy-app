package com.vodafone.er.ecom.proxy;

import com.vizzavi.ecommerce.business.catalog.CatalogApi;
import com.vizzavi.ecommerce.business.catalog.CatalogService;
import com.vizzavi.ecommerce.business.common.EcomApiFactory;
import com.vizzavi.ecommerce.business.common.EcommerceException;
import org.apache.log4j.*;
import org.assertj.core.api.SoftAssertions;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AllowSymLinkAliasChecker;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.*;

import java.io.File;
import java.io.OutputStreamWriter;
import java.util.Locale;

import static junit.framework.TestCase.assertNotNull;

public class GetService_IT {

    private static final int JETTY_PORT = 8888;
    //    private static final String WAR_PATH = "./ecom-proxy-app/target/ecom-proxy-app.war";
    private static final String WAR_PATH = "./target/ecom-proxy-app.war";
    private static final String CONTEXT_PATH = "/delegates";

    private static Server server;

    String clientId = "AdhocTestClient";


//    @BeforeClass
//    public static void startJetty() throws Exception {
//        BasicConfigurator.configure();
////        overrideProperties();
////        setLog(new Slf4jLog());
//
////        Logger.getRootLogger().setLevel(Level.DEBUG);
////        Logger.getLogger("com.vodafone").setLevel(Level.DEBUG);
//
//        Logger logger = Logger.getLogger("com.vodafone");
//
//        ConsoleAppender ca = new ConsoleAppender(new PatternLayout("%-5p [%t]: %m%n"));
//        ca.setWriter(new OutputStreamWriter(System.out));
//        Logger.getLogger("com.vodafone").addAppender(ca);
//        Logger.getRootLogger().addAppender(ca);
//        Logger.getLogger("com.vodafone.config").setLevel(Level.OFF);
//        Logger.getLogger("org.eclipse").setLevel(Level.ERROR);
//        Logger.getLogger("org.springframework").setLevel(Level.OFF);
////        Logger.getLogger("org.springframework").addAppender(ca);
//
//        try {
//            server = new Server(JETTY_PORT);
//        } catch (Throwable thr) {
//            thr.printStackTrace();
//        }
//
////        MBeanContainer mbContainer = new MBeanContainer(
////                ManagementFactory.getPlatformMBeanServer());
////        server.addBean(mbContainer);
//
//
//        ContextHandler contextHandler = new ContextHandler();
//        contextHandler.setContextPath("/delegates");
//
//        WebAppContext webAppContext = new WebAppContext();
//        webAppContext.setContextPath(CONTEXT_PATH);
//        File warfile = new File(WAR_PATH);
//        System.out.println("Warfile present: " + warfile.exists());
//        System.out.println("Warfile path: " + warfile.getAbsolutePath());
//
//        System.out.println(">>>>>" + System.getProperty("user.dir"));
//
////        setSystemProperties();
//
//        webAppContext.setWar(warfile.getAbsolutePath());
//
//        webAppContext.addAliasCheck(new AllowSymLinkAliasChecker());
//        server.setHandler(webAppContext);
//
////        startServer();
//        System.out.println("STATE=" + server.getState());
//        server.start();
////        server.join();
//        System.out.println("STATE=" + server.getState());
//
//
//        System.out.println( "SERVER STATUS " + server.getState() );
//
//    }
//
//    @AfterClass
//    public static void tearDownJetty() throws Exception {
//        System.out.println( "STOPPING SERVER " + server.getState() );
//        server.stop();
////        server.join();
//        System.out.println( "STOPPED SERVER " + server.getState() );
//    }

    private SoftAssertions softly = new SoftAssertions();

    private CatalogApi catalogApi;

    private CatalogApi getCatalogApi() throws EcommerceException {
        if (catalogApi==null)
            catalogApi = EcomApiFactory.getCatalogApi(Locale.UK);
        return catalogApi;
    }

    @Test
    public void testGetService1() throws Exception {

        final CatalogService catalogService = getCatalogApi().getService("sAlt");
        assertNotNull(catalogService);

        softly.assertThat(catalogService.getName() ).as(" catalogService.getName()" ).isEqualTo("Alternative Payment Service");
        softly.assertThat(catalogService.getKey() ).as(" catalogService.getKey()" ).isNull();
// java.util.HashSet
        softly.assertThat(catalogService.getId() ).as(" catalogService.getId()" ).isEqualTo("sAlt");
        softly.assertThat(catalogService.getDisplayName() ).as(" catalogService.getDisplayName()" ).isEqualTo("sAlt (Alternative Payment Service)");
// java.util.HashMap
        softly.assertThat(catalogService.getNotificationCategory() ).as(" catalogService.getNotificationCategory()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getNotificationCategory() ).as(" catalogService.getNotificationCategory()" ).isEqualTo("");
        softly.assertThat(catalogService.getNonRefundableDescription() ).as(" catalogService.getNonRefundableDescription()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getNonRefundableDescription() ).as(" catalogService.getNonRefundableDescription()" ).isEqualTo("");
        softly.assertThat(catalogService.isRefundable() ).as(" catalogService.isRefundable()" ).isTrue() ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(catalogService.getPricePoints().get(0).getKey() ).as(" catalogService.getPricePoints().get(0).getKey()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getId() ).as(" catalogService.getPricePoints().get(0).getId()" ).isEqualTo("content:pAlt_TAX_sAlt_1_999_999_999");
// com.vizzavi.ecommerce.business.catalog.Tax
        softly.assertThat(catalogService.getPricePoints().get(0).getRate() ).as(" catalogService.getPricePoints().get(0).getRate()" ).isEqualTo(new Double(2.35)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).isReserveOnly() ).as(" catalogService.getPricePoints().get(0).isReserveOnly()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricingText1() ).as(" catalogService.getPricePoints().get(0).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricingText1() ).as(" catalogService.getPricePoints().get(0).getPricingText1()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(0).getPricingText2() ).as(" catalogService.getPricePoints().get(0).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricingText2() ).as(" catalogService.getPricePoints().get(0).getPricingText2()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(0).getStartDate() ).as(" catalogService.getPricePoints().get(0).getStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getExpiryDate() ).as(" catalogService.getPricePoints().get(0).getExpiryDate()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).isOriginal() ).as(" catalogService.getPricePoints().get(0).isOriginal()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).isEvent() ).as(" catalogService.getPricePoints().get(0).isEvent()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isRecurring() ).as(" catalogService.getPricePoints().get(0).isRecurring()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isHistoric() ).as(" catalogService.getPricePoints().get(0).isHistoric()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricepointIdLink() ).as(" catalogService.getPricePoints().get(0).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(0).isTrial() ).as(" catalogService.getPricePoints().get(0).isTrial()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).isNonRecurring() ).as(" catalogService.getPricePoints().get(0).isNonRecurring()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPackageId() ).as(" catalogService.getPricePoints().get(0).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(catalogService.getPricePoints().get(0).isPromo() ).as(" catalogService.getPricePoints().get(0).isPromo()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getAccessDevice() ).as(" catalogService.getPricePoints().get(0).getAccessDevice()" ).isEqualTo(999) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts()).as("catalogService.getPricePoints().get(0).getAllBalanceImpacts()").isNotNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getId() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getType() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource() ).as(" catalogService.getPricePoints().get(0).getAllBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getServiceIdentifier() ).as(" catalogService.getPricePoints().get(0).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_sAlt_1_999_*_999_999");
        softly.assertThat(catalogService.getPricePoints().get(0).getPackageIdentifier() ).as(" catalogService.getPricePoints().get(0).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_999_999_999_999_1_*_*_*_false_false_*");
        softly.assertThat(catalogService.getPricePoints().get(0).isPreOrder() ).as(" catalogService.getPricePoints().get(0).isPreOrder()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getTaxRate() ).as(" catalogService.getPricePoints().get(0).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getTaxCode() ).as(" catalogService.getPricePoints().get(0).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(catalogService.getPricePoints().get(0).getLinkedByTrialPricepoint() ).as(" catalogService.getPricePoints().get(0).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getDescription() ).as(" catalogService.getPricePoints().get(0).getDescription()" ).isEqualTo("Default (event) , Channel 1");
        softly.assertThat(catalogService.getPricePoints().get(0).isActive() ).as(" catalogService.getPricePoints().get(0).isActive()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isZeroCostIgnore() ).as(" catalogService.getPricePoints().get(0).isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricingModelTier() ).as(" catalogService.getPricePoints().get(0).getPricingModelTier()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).isArchived() ).as(" catalogService.getPricePoints().get(0).isArchived()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isBasePricePoint() ).as(" catalogService.getPricePoints().get(0).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getNetRate() ).as(" catalogService.getPricePoints().get(0).getNetRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getAlternativeRate() ).as(" catalogService.getPricePoints().get(0).getAlternativeRate()" ).isEqualTo(new Double(2.35)) ;

        //TODO
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()).as("catalogService.getPricePoints().get(0).getBalanceImpacts() is null").isNotNull();

//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getName() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getName()" ).isEqualTo("GBP");
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isCurrency() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isCurrency()" ).isTrue() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isResource() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isResource()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getDescription() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getDescription()" ).isEqualTo("British Pound Sterling");
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isToken() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isPayToken() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getResourceName() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_826");
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_826");
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getCountryId() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getCode() ).as(" catalogService.getPricePoints().get(0).getBalanceImpacts()[0].getCode()" ).isEqualTo(826) ;
// com.vizzavi.ecommerce.business.common.ChargingResource

        //TODO List should not be empty
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList()" ).isNotNull();

        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getKey() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getId() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getType() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getRate() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).isResource() ).as(" catalogService.getPricePoints().get(0).getBalanceImpactList().get(0).isResource()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getGlid() ).as(" catalogService.getPricePoints().get(0).getGlid()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(0).getGlid() ).as(" catalogService.getPricePoints().get(0).getGlid()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(0).getContentId() ).as(" catalogService.getPricePoints().get(0).getContentId()" ).isEqualTo("sAlt");
        softly.assertThat(catalogService.getPricePoints().get(0).isDiscount() ).as(" catalogService.getPricePoints().get(0).isDiscount()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getStandardRate() ).as(" catalogService.getPricePoints().get(0).getStandardRate()" ).isEqualTo(new Double(2.35)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getDiscountPromoText() ).as(" catalogService.getPricePoints().get(0).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(0).getDiscountPromoText() ).as(" catalogService.getPricePoints().get(0).getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(0).isPreview() ).as(" catalogService.getPricePoints().get(0).isPreview()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getInteractiveFlag() ).as(" catalogService.getPricePoints().get(0).getInteractiveFlag()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(0).isForcedPurchase() ).as(" catalogService.getPricePoints().get(0).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isSubscriptionDuplicate() ).as(" catalogService.getPricePoints().get(0).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getFixedExpiryDate() ).as(" catalogService.getPricePoints().get(0).getFixedExpiryDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getMinSubPeriod() ).as(" catalogService.getPricePoints().get(0).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPenaltyCharges() ).as(" catalogService.getPricePoints().get(0).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getCancellation() ).as(" catalogService.getPricePoints().get(0).getCancellation()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getMonthEndSubscription() ).as(" catalogService.getPricePoints().get(0).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(catalogService.getPricePoints().get(0).getFixedRecurrence() ).as(" catalogService.getPricePoints().get(0).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).isFixedRecurringPricePoint() ).as(" catalogService.getPricePoints().get(0).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isReceipting() ).as(" catalogService.getPricePoints().get(0).isReceipting()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getReceiptingAttribute() ).as(" catalogService.getPricePoints().get(0).getReceiptingAttribute()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getOrder() ).as(" catalogService.getPricePoints().get(0).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPaymentHandler() ).as(" catalogService.getPricePoints().get(0).getPaymentHandler()" ).isEqualTo("NULL");
        softly.assertThat(catalogService.getPricePoints().get(0).isSubmitToPaymentHandler() ).as(" catalogService.getPricePoints().get(0).isSubmitToPaymentHandler()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).isSuppressToPaymentHandler() ).as(" catalogService.getPricePoints().get(0).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricingTextTemplateName1() ).as(" catalogService.getPricePoints().get(0).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricingTextTemplateName2() ).as(" catalogService.getPricePoints().get(0).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getTranslatedPricingText1() ).as(" catalogService.getPricePoints().get(0).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getTranslatedPricingText2() ).as(" catalogService.getPricePoints().get(0).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getUsageTime() ).as(" catalogService.getPricePoints().get(0).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getRecurrenceDay() ).as(" catalogService.getPricePoints().get(0).getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(0).isAlignWithExternal() ).as(" catalogService.getPricePoints().get(0).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getAccessDuration() ).as(" catalogService.getPricePoints().get(0).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getGracePeriod() ).as(" catalogService.getPricePoints().get(0).getGracePeriod()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getRetryFrequency() ).as(" catalogService.getPricePoints().get(0).getRetryFrequency()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getSuspensionPeriod() ).as(" catalogService.getPricePoints().get(0).getSuspensionPeriod()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined() ).as(" catalogService.getPricePoints().get(0).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getTranslatedPricingText() ).as(" catalogService.getPricePoints().get(0).getTranslatedPricingText()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(0).getFairUsageLimit() ).as(" catalogService.getPricePoints().get(0).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getFairUsagePeriod() ).as(" catalogService.getPricePoints().get(0).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getFairUsagePeriodUnit() ).as(" catalogService.getPricePoints().get(0).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(catalogService.getPricePoints().get(0).getExtensionPeriod() ).as(" catalogService.getPricePoints().get(0).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(0).isIncludeServiceForPackageFUP() ).as(" catalogService.getPricePoints().get(0).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isFairUsagePolicyEnabled() ).as(" catalogService.getPricePoints().get(0).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isTariff() ).as(" catalogService.getPricePoints().get(0).isTariff()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isHideForPurchaseOptions() ).as(" catalogService.getPricePoints().get(0).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource

        softly.assertThat(catalogService.getPricePoints().get(0).getResourceBalances() ).as(" catalogService.getPricePoints().get(0).getResourceBalances()" ).isNotNull();

//        softly.assertThat(catalogService.getPricePoints().get(0).getResourceBalances()[0].getPackageId() ).as(" catalogService.getPricePoints().get(0).getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getResourceBalances()[0].getThreshold() ).as(" catalogService.getPricePoints().get(0).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId() ).as(" catalogService.getPricePoints().get(0).getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong() ).as(" catalogService.getPricePoints().get(0).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId() ).as(" catalogService.getPricePoints().get(0).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getResourceBalances()[0].getSubscription() ).as(" catalogService.getPricePoints().get(0).getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getResourceBalances()[0].getBalance() ).as(" catalogService.getPricePoints().get(0).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getCustomResourceBalances() ).as(" catalogService.getPricePoints().get(0).getCustomResourceBalances()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).isAlwaysValidateMsisdn() ).as(" catalogService.getPricePoints().get(0).isAlwaysValidateMsisdn()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource


        softly.assertThat(catalogService.getPricePoints().get(0).getBalances() ).as(" catalogService.getPricePoints().get(0).getBalances()" ).isNotNull();

//        softly.assertThat(catalogService.getPricePoints().get(0).getBalances()[0].getPackageId() ).as(" catalogService.getPricePoints().get(0).getBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalances()[0].getThreshold() ).as(" catalogService.getPricePoints().get(0).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalances()[0].getSubscriptionId() ).as(" catalogService.getPricePoints().get(0).getBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong() ).as(" catalogService.getPricePoints().get(0).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId() ).as(" catalogService.getPricePoints().get(0).getBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalances()[0].getSubscription() ).as(" catalogService.getPricePoints().get(0).getBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getBalances()[0].getBalance() ).as(" catalogService.getPricePoints().get(0).getBalances()[0].getBalance()" ).isEqualTo(new Double(2.0)) ;

        softly.assertThat(catalogService.getPricePoints().get(0).getRenewalsUntilLinkedPricepoint() ).as(" catalogService.getPricePoints().get(0).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getStandardRateWithoutTax() ).as(" catalogService.getPricePoints().get(0).getStandardRateWithoutTax()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).isVolumeType() ).as(" catalogService.getPricePoints().get(0).isVolumeType()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getKey() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getKey()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource

        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts()" ).isNotNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("826");
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(2.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getPricingModel() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getTier() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" catalogService.getPricePoints().get(0).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getProtectedFk() ).as(" catalogService.getPricePoints().get(0).getProtectedFk()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getmPricingText1() ).as(" catalogService.getPricePoints().get(0).getmPricingText1()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(0).getmPricingText2() ).as(" catalogService.getPricePoints().get(0).getmPricingText2()" ).isEqualTo("");
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
// com.vizzavi.ecommerce.business.common.ChargingResource
// java.util.HashMap
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(catalogService.getPricePoints().get(0).getChannel() ).as(" catalogService.getPricePoints().get(0).getChannel()" ).isEqualTo(1) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getMultiUsageMode() ).as(" catalogService.getPricePoints().get(0).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getNetworkCodeMatchMethod() ).as(" catalogService.getPricePoints().get(0).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(0).isPreRatePriceGross() ).as(" catalogService.getPricePoints().get(0).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPreRate() ).as(" catalogService.getPricePoints().get(0).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPaymentInformation() ).as(" catalogService.getPricePoints().get(0).getPaymentInformation()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getContentName() ).as(" catalogService.getPricePoints().get(0).getContentName()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getAssetID() ).as(" catalogService.getPricePoints().get(0).getAssetID()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPremiumLevel() ).as(" catalogService.getPricePoints().get(0).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getReserveOnlyFlag() ).as(" catalogService.getPricePoints().get(0).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getSupplierId() ).as(" catalogService.getPricePoints().get(0).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(0).getDeviceType() ).as(" catalogService.getPricePoints().get(0).getDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getUserGroup() ).as(" catalogService.getPricePoints().get(0).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(0).getPaymentType() ).as(" catalogService.getPricePoints().get(0).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getEventDateTime() ).as(" catalogService.getPricePoints().get(0).getEventDateTime()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getEventUnits() ).as(" catalogService.getPricePoints().get(0).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPromoCode() ).as(" catalogService.getPricePoints().get(0).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(0).getDuration() ).as(" catalogService.getPricePoints().get(0).getDuration()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getChargingMethod() ).as(" catalogService.getPricePoints().get(0).getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getBearer() ).as(" catalogService.getPricePoints().get(0).getBearer()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(0).isInteractive() ).as(" catalogService.getPricePoints().get(0).isInteractive()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isIncludeUnavailable() ).as(" catalogService.getPricePoints().get(0).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getExpressFlag() ).as(" catalogService.getPricePoints().get(0).getExpressFlag()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isExpressFlag() ).as(" catalogService.getPricePoints().get(0).isExpressFlag()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isCancellationUsage() ).as(" catalogService.getPricePoints().get(0).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getTierName() ).as(" catalogService.getPricePoints().get(0).getTierName()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPromoPrecode() ).as(" catalogService.getPricePoints().get(0).getPromoPrecode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getUniquePromoCode() ).as(" catalogService.getPricePoints().get(0).getUniquePromoCode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPromoUniqueCode() ).as(" catalogService.getPricePoints().get(0).getPromoUniqueCode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getNextCycleDiscount() ).as(" catalogService.getPricePoints().get(0).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getHasHistoricPricePointFlag() ).as(" catalogService.getPricePoints().get(0).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isIsForRenewal() ).as(" catalogService.getPricePoints().get(0).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getTaxRateAsDouble() ).as(" catalogService.getPricePoints().get(0).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getAffiliateID() ).as(" catalogService.getPricePoints().get(0).getAffiliateID()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPartnerId() ).as(" catalogService.getPricePoints().get(0).getPartnerId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getTariff() ).as(" catalogService.getPricePoints().get(0).getTariff()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(0).getAggregatorId() ).as(" catalogService.getPricePoints().get(0).getAggregatorId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).isForcePurchaseFlow() ).as(" catalogService.getPricePoints().get(0).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getReceipientMsisdn() ).as(" catalogService.getPricePoints().get(0).getReceipientMsisdn()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getProductCode() ).as(" catalogService.getPricePoints().get(0).getProductCode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getMerchantName() ).as(" catalogService.getPricePoints().get(0).getMerchantName()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getInvoiceText() ).as(" catalogService.getPricePoints().get(0).getInvoiceText()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).isReIssueEnabled() ).as(" catalogService.getPricePoints().get(0).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).isReIssueFlagPresent() ).as(" catalogService.getPricePoints().get(0).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getShortPackageId() ).as(" catalogService.getPricePoints().get(0).getShortPackageId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getHistoryStartDate() ).as(" catalogService.getPricePoints().get(0).getHistoryStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getVendorId() ).as(" catalogService.getPricePoints().get(0).getVendorId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).isIsForNextPaymentAmount() ).as(" catalogService.getPricePoints().get(0).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getRenewalPreRate() ).as(" catalogService.getPricePoints().get(0).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(0).isOverrideDisallowPreRateFlag() ).as(" catalogService.getPricePoints().get(0).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getContentCategory() ).as(" catalogService.getPricePoints().get(0).getContentCategory()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPartnerUrl() ).as(" catalogService.getPricePoints().get(0).getPartnerUrl()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPartnerContactInfo() ).as(" catalogService.getPricePoints().get(0).getPartnerContactInfo()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPartnerEmail() ).as(" catalogService.getPricePoints().get(0).getPartnerEmail()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getPartnerName() ).as(" catalogService.getPricePoints().get(0).getPartnerName()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint() ).as(" catalogService.getPricePoints().get(0).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint() ).as(" catalogService.getPricePoints().get(0).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(0).getSubRenewalPricepointId() ).as(" catalogService.getPricePoints().get(0).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getLinkPricepointId() ).as(" catalogService.getPricePoints().get(0).getLinkPricepointId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getSubPurchaseTransactionTrial() ).as(" catalogService.getPricePoints().get(0).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(0).getDiscardHiddenInactivePricepoints() ).as(" catalogService.getPricePoints().get(0).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints() ).as(" catalogService.getPricePoints().get(0).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(0).getExtIdentifier1() ).as(" catalogService.getPricePoints().get(0).getExtIdentifier1()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getExtIdentifier2() ).as(" catalogService.getPricePoints().get(0).getExtIdentifier2()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(0).getExtIdentifier3() ).as(" catalogService.getPricePoints().get(0).getExtIdentifier3()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getAccessChannel() ).as(" catalogService.getPricePoints().get(0).getAccessChannel()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getPurchaseChannel() ).as(" catalogService.getPricePoints().get(0).getPurchaseChannel()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getDeviceID() ).as(" catalogService.getPricePoints().get(0).getDeviceID()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getLocal() ).as(" catalogService.getPricePoints().get(0).getLocal()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getMsisdn() ).as(" catalogService.getPricePoints().get(0).getMsisdn()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getLanguageLocale() ).as(" catalogService.getPricePoints().get(0).getLanguageLocale()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getLanguageCode() ).as(" catalogService.getPricePoints().get(0).getLanguageCode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getExternalField1() ).as(" catalogService.getPricePoints().get(0).getExternalField1()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getExternalField2() ).as(" catalogService.getPricePoints().get(0).getExternalField2()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getExternalTransId() ).as(" catalogService.getPricePoints().get(0).getExternalTransId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getActiveSubscriptions() ).as(" catalogService.getPricePoints().get(0).getActiveSubscriptions()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(0).getCsrId() ).as(" catalogService.getPricePoints().get(0).getCsrId()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(catalogService.getPricePoints().get(1).getKey() ).as(" catalogService.getPricePoints().get(1).getKey()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getId() ).as(" catalogService.getPricePoints().get(1).getId()" ).isEqualTo("content:pAlt_TAX_sAlt_999_999_999_999");
// com.vizzavi.ecommerce.business.catalog.Tax
        softly.assertThat(catalogService.getPricePoints().get(1).getRate() ).as(" catalogService.getPricePoints().get(1).getRate()" ).isEqualTo(new Double(1.175)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).isReserveOnly() ).as(" catalogService.getPricePoints().get(1).isReserveOnly()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricingText1() ).as(" catalogService.getPricePoints().get(1).getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricingText1() ).as(" catalogService.getPricePoints().get(1).getPricingText1()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(1).getPricingText2() ).as(" catalogService.getPricePoints().get(1).getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricingText2() ).as(" catalogService.getPricePoints().get(1).getPricingText2()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(1).getStartDate() ).as(" catalogService.getPricePoints().get(1).getStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getExpiryDate() ).as(" catalogService.getPricePoints().get(1).getExpiryDate()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).isOriginal() ).as(" catalogService.getPricePoints().get(1).isOriginal()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).isEvent() ).as(" catalogService.getPricePoints().get(1).isEvent()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isRecurring() ).as(" catalogService.getPricePoints().get(1).isRecurring()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isHistoric() ).as(" catalogService.getPricePoints().get(1).isHistoric()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricepointIdLink() ).as(" catalogService.getPricePoints().get(1).getPricepointIdLink()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(1).isTrial() ).as(" catalogService.getPricePoints().get(1).isTrial()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).isNonRecurring() ).as(" catalogService.getPricePoints().get(1).isNonRecurring()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPackageId() ).as(" catalogService.getPricePoints().get(1).getPackageId()" ).isEqualTo("pAlt");
        softly.assertThat(catalogService.getPricePoints().get(1).isPromo() ).as(" catalogService.getPricePoints().get(1).isPromo()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getAccessDevice() ).as(" catalogService.getPricePoints().get(1).getAccessDevice()" ).isEqualTo(999) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getKey() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getId() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getType() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getRate() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getFixedAmount() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getScaledAmount() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getNotificationThreshold() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getPricePoint() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).isCurrency() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).isResource() ).as(" catalogService.getPricePoints().get(1).getAllBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getServiceIdentifier() ).as(" catalogService.getPricePoints().get(1).getServiceIdentifier()" ).isEqualTo("content:pAlt_TAX_sAlt_999_999_*_999_999");
        softly.assertThat(catalogService.getPricePoints().get(1).getPackageIdentifier() ).as(" catalogService.getPricePoints().get(1).getPackageIdentifier()" ).isEqualTo("package:pAlt_TAX_999_999_999_999_999_*_*_*_false_false_*");
        softly.assertThat(catalogService.getPricePoints().get(1).isPreOrder() ).as(" catalogService.getPricePoints().get(1).isPreOrder()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getTaxRate() ).as(" catalogService.getPricePoints().get(1).getTaxRate()" ).isEqualTo(new Double(0.175)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getTaxCode() ).as(" catalogService.getPricePoints().get(1).getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(catalogService.getPricePoints().get(1).getLinkedByTrialPricepoint() ).as(" catalogService.getPricePoints().get(1).getLinkedByTrialPricepoint()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getDescription() ).as(" catalogService.getPricePoints().get(1).getDescription()" ).isEqualTo("Default (event) ");
        softly.assertThat(catalogService.getPricePoints().get(1).isActive() ).as(" catalogService.getPricePoints().get(1).isActive()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isZeroCostIgnore() ).as(" catalogService.getPricePoints().get(1).isZeroCostIgnore()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricingModelTier() ).as(" catalogService.getPricePoints().get(1).getPricingModelTier()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).isArchived() ).as(" catalogService.getPricePoints().get(1).isArchived()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isBasePricePoint() ).as(" catalogService.getPricePoints().get(1).isBasePricePoint()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getNetRate() ).as(" catalogService.getPricePoints().get(1).getNetRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getAlternativeRate() ).as(" catalogService.getPricePoints().get(1).getAlternativeRate()" ).isEqualTo(new Double(1.175)) ;

        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()" ).isNotNull();

//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getName() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getName()" ).isEqualTo("Content Credit");
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isCurrency() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isCurrency()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isResource() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isResource()" ).isTrue() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getDescription() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getDescription()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isToken() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isToken()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isUsageToken() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isUsageToken()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isPayToken() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].isPayToken()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getResourceName() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getResourceName()" ).isEqualTo("ChargingResource_1100035");
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getResourceSymbol() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getResourceSymbol()" ).isEqualTo("ChargingResource_Symbol_1100035");
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getCountryId() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getCountryId()" ).isEqualTo(0) ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getCode() ).as(" catalogService.getPricePoints().get(1).getBalanceImpacts()[0].getCode()" ).isEqualTo(1100035) ;
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getKey() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getKey()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getId() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getType() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getRate() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getPriceChangeStartDate() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getFixedAmount() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getScaledAmount() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getNotificationThreshold() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getPricePoint() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).getPricePoint()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).isCurrency() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).isResource() ).as(" catalogService.getPricePoints().get(1).getBalanceImpactList().get(0).isResource()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getGlid() ).as(" catalogService.getPricePoints().get(1).getGlid()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(1).getGlid() ).as(" catalogService.getPricePoints().get(1).getGlid()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(1).getContentId() ).as(" catalogService.getPricePoints().get(1).getContentId()" ).isEqualTo("sAlt");
        softly.assertThat(catalogService.getPricePoints().get(1).isDiscount() ).as(" catalogService.getPricePoints().get(1).isDiscount()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getStandardRate() ).as(" catalogService.getPricePoints().get(1).getStandardRate()" ).isEqualTo(new Double(1.175)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getDiscountPromoText() ).as(" catalogService.getPricePoints().get(1).getDiscountPromoText()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(1).getDiscountPromoText() ).as(" catalogService.getPricePoints().get(1).getDiscountPromoText()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoints().get(1).isPreview() ).as(" catalogService.getPricePoints().get(1).isPreview()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getInteractiveFlag() ).as(" catalogService.getPricePoints().get(1).getInteractiveFlag()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).isForcedPurchase() ).as(" catalogService.getPricePoints().get(1).isForcedPurchase()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isSubscriptionDuplicate() ).as(" catalogService.getPricePoints().get(1).isSubscriptionDuplicate()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getFixedExpiryDate() ).as(" catalogService.getPricePoints().get(1).getFixedExpiryDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getMinSubPeriod() ).as(" catalogService.getPricePoints().get(1).getMinSubPeriod()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPenaltyCharges() ).as(" catalogService.getPricePoints().get(1).getPenaltyCharges()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getCancellation() ).as(" catalogService.getPricePoints().get(1).getCancellation()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getMonthEndSubscription() ).as(" catalogService.getPricePoints().get(1).getMonthEndSubscription()" ).isEqualTo("NULL");
        softly.assertThat(catalogService.getPricePoints().get(1).getFixedRecurrence() ).as(" catalogService.getPricePoints().get(1).getFixedRecurrence()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).isFixedRecurringPricePoint() ).as(" catalogService.getPricePoints().get(1).isFixedRecurringPricePoint()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isReceipting() ).as(" catalogService.getPricePoints().get(1).isReceipting()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getReceiptingAttribute() ).as(" catalogService.getPricePoints().get(1).getReceiptingAttribute()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getOrder() ).as(" catalogService.getPricePoints().get(1).getOrder()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPaymentHandler() ).as(" catalogService.getPricePoints().get(1).getPaymentHandler()" ).isEqualTo("NULL");
        softly.assertThat(catalogService.getPricePoints().get(1).isSubmitToPaymentHandler() ).as(" catalogService.getPricePoints().get(1).isSubmitToPaymentHandler()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).isSuppressToPaymentHandler() ).as(" catalogService.getPricePoints().get(1).isSuppressToPaymentHandler()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricingTextTemplateName1() ).as(" catalogService.getPricePoints().get(1).getPricingTextTemplateName1()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricingTextTemplateName2() ).as(" catalogService.getPricePoints().get(1).getPricingTextTemplateName2()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getTranslatedPricingText1() ).as(" catalogService.getPricePoints().get(1).getTranslatedPricingText1()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getTranslatedPricingText2() ).as(" catalogService.getPricePoints().get(1).getTranslatedPricingText2()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getUsageTime() ).as(" catalogService.getPricePoints().get(1).getUsageTime()" ).isEqualTo(new Long(0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getRecurrenceDay() ).as(" catalogService.getPricePoints().get(1).getRecurrenceDay()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(1).isAlignWithExternal() ).as(" catalogService.getPricePoints().get(1).isAlignWithExternal()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getAccessDuration() ).as(" catalogService.getPricePoints().get(1).getAccessDuration()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getGracePeriod() ).as(" catalogService.getPricePoints().get(1).getGracePeriod()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getRetryFrequency() ).as(" catalogService.getPricePoints().get(1).getRetryFrequency()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getSuspensionPeriod() ).as(" catalogService.getPricePoints().get(1).getSuspensionPeriod()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).isGraceSuspensionRetryFrequencyUndefined() ).as(" catalogService.getPricePoints().get(1).isGraceSuspensionRetryFrequencyUndefined()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getTranslatedPricingText() ).as(" catalogService.getPricePoints().get(1).getTranslatedPricingText()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getFairUsageLimit() ).as(" catalogService.getPricePoints().get(1).getFairUsageLimit()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getFairUsagePeriod() ).as(" catalogService.getPricePoints().get(1).getFairUsagePeriod()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getFairUsagePeriodUnit() ).as(" catalogService.getPricePoints().get(1).getFairUsagePeriodUnit()" ).isEqualTo("Day(s)");
        softly.assertThat(catalogService.getPricePoints().get(1).getExtensionPeriod() ).as(" catalogService.getPricePoints().get(1).getExtensionPeriod()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(1).isIncludeServiceForPackageFUP() ).as(" catalogService.getPricePoints().get(1).isIncludeServiceForPackageFUP()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isFairUsagePolicyEnabled() ).as(" catalogService.getPricePoints().get(1).isFairUsagePolicyEnabled()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isTariff() ).as(" catalogService.getPricePoints().get(1).isTariff()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isHideForPurchaseOptions() ).as(" catalogService.getPricePoints().get(1).isHideForPurchaseOptions()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource

        softly.assertThat(catalogService.getPricePoints().get(1).getResourceBalances() ).as(" catalogService.getPricePoints().get(1).getResourceBalances()" ).isNotNull();

//        softly.assertThat(catalogService.getPricePoints().get(1).getResourceBalances()[0].getPackageId() ).as(" catalogService.getPricePoints().get(1).getResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getResourceBalances()[0].getThreshold() ).as(" catalogService.getPricePoints().get(1).getResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId() ).as(" catalogService.getPricePoints().get(1).getResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong() ).as(" catalogService.getPricePoints().get(1).getResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId() ).as(" catalogService.getPricePoints().get(1).getResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getResourceBalances()[0].getSubscription() ).as(" catalogService.getPricePoints().get(1).getResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getResourceBalances()[0].getBalance() ).as(" catalogService.getPricePoints().get(1).getResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
// com.vizzavi.ecommerce.business.common.ChargingResource

        softly.assertThat(catalogService.getPricePoints().get(1).getCustomResourceBalances()).as(" catalogService.getPricePoints().get(1).getCustomResourceBalances()" ).isNotNull();

//        softly.assertThat(catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId() ).as(" catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold() ).as(" catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId() ).as(" catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong() ).as(" catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId() ).as(" catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription() ).as(" catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getBalance() ).as(" catalogService.getPricePoints().get(1).getCustomResourceBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
//        softly.assertThat(catalogService.getPricePoints().get(1).isAlwaysValidateMsisdn() ).as(" catalogService.getPricePoints().get(1).isAlwaysValidateMsisdn()" ).isFalse() ;
// com.vizzavi.ecommerce.business.common.ChargingResource

        softly.assertThat(catalogService.getPricePoints().get(1).getBalances()).as(" catalogService.getPricePoints().get(1).getBalances()" ).isNotNull();

//        softly.assertThat(catalogService.getPricePoints().get(1).getBalances()[0].getPackageId() ).as(" catalogService.getPricePoints().get(1).getBalances()[0].getPackageId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalances()[0].getThreshold() ).as(" catalogService.getPricePoints().get(1).getBalances()[0].getThreshold()" ).isEqualTo(0) ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalances()[0].getSubscriptionId() ).as(" catalogService.getPricePoints().get(1).getBalances()[0].getSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalances()[0].getSubscriptionIdLong() ).as(" catalogService.getPricePoints().get(1).getBalances()[0].getSubscriptionIdLong()" ).isEqualTo(new Long(-1)) ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalances()[0].getOldestSubscriptionId() ).as(" catalogService.getPricePoints().get(1).getBalances()[0].getOldestSubscriptionId()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalances()[0].getSubscription() ).as(" catalogService.getPricePoints().get(1).getBalances()[0].getSubscription()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getBalances()[0].getBalance() ).as(" catalogService.getPricePoints().get(1).getBalances()[0].getBalance()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getRenewalsUntilLinkedPricepoint() ).as(" catalogService.getPricePoints().get(1).getRenewalsUntilLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getStandardRateWithoutTax() ).as(" catalogService.getPricePoints().get(1).getStandardRateWithoutTax()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).isVolumeType() ).as(" catalogService.getPricePoints().get(1).isVolumeType()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getKey() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getKey()" ).isNull();
// com.vizzavi.ecommerce.business.common.ChargingResource
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getKey()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getId()" ).isEqualTo("1100035");
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getType()" ).isEqualTo("CREDIT");
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getRate()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPriceChangeStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getFixedAmount()" ).isEqualTo(new Double(1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getScaledAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getNotificationThreshold()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).getPricePoint()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isCurrency()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getBalanceImpacts().get(0).isResource()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getPricingModel() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getPricingModel()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPrice()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingText()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getTier() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getTier()" ).isEqualTo("default");
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].isDefaultPPT()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList() ).as(" catalogService.getPricePoints().get(1).getPricePointTiers()[0].getPromotionalPricingTextList()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getProtectedFk() ).as(" catalogService.getPricePoints().get(1).getProtectedFk()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getmPricingText1() ).as(" catalogService.getPricePoints().get(1).getmPricingText1()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricePoints().get(1).getmPricingText2() ).as(" catalogService.getPricePoints().get(1).getmPricingText2()" ).isEqualTo("");
// com.vizzavi.ecommerce.business.catalog.internal.PricePointTier
// com.vizzavi.ecommerce.business.common.ChargingResource
// java.util.HashMap
// java.util.HashMap
// java.util.HashMap
        softly.assertThat(catalogService.getPricePoints().get(1).getChannel() ).as(" catalogService.getPricePoints().get(1).getChannel()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getMultiUsageMode() ).as(" catalogService.getPricePoints().get(1).getMultiUsageMode()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getNetworkCodeMatchMethod() ).as(" catalogService.getPricePoints().get(1).getNetworkCodeMatchMethod()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(1).isPreRatePriceGross() ).as(" catalogService.getPricePoints().get(1).isPreRatePriceGross()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPreRate() ).as(" catalogService.getPricePoints().get(1).getPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPaymentInformation() ).as(" catalogService.getPricePoints().get(1).getPaymentInformation()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getContentName() ).as(" catalogService.getPricePoints().get(1).getContentName()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getAssetID() ).as(" catalogService.getPricePoints().get(1).getAssetID()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPremiumLevel() ).as(" catalogService.getPricePoints().get(1).getPremiumLevel()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getReserveOnlyFlag() ).as(" catalogService.getPricePoints().get(1).getReserveOnlyFlag()" ).isEqualTo(0) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getSupplierId() ).as(" catalogService.getPricePoints().get(1).getSupplierId()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(1).getDeviceType() ).as(" catalogService.getPricePoints().get(1).getDeviceType()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getUserGroup() ).as(" catalogService.getPricePoints().get(1).getUserGroup()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(1).getPaymentType() ).as(" catalogService.getPricePoints().get(1).getPaymentType()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getEventDateTime() ).as(" catalogService.getPricePoints().get(1).getEventDateTime()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getEventUnits() ).as(" catalogService.getPricePoints().get(1).getEventUnits()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPromoCode() ).as(" catalogService.getPricePoints().get(1).getPromoCode()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(1).getDuration() ).as(" catalogService.getPricePoints().get(1).getDuration()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getChargingMethod() ).as(" catalogService.getPricePoints().get(1).getChargingMethod()" ).isEqualTo(999) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getBearer() ).as(" catalogService.getPricePoints().get(1).getBearer()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(1).isInteractive() ).as(" catalogService.getPricePoints().get(1).isInteractive()" ).isTrue() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isIncludeUnavailable() ).as(" catalogService.getPricePoints().get(1).isIncludeUnavailable()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getExpressFlag() ).as(" catalogService.getPricePoints().get(1).getExpressFlag()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isExpressFlag() ).as(" catalogService.getPricePoints().get(1).isExpressFlag()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isCancellationUsage() ).as(" catalogService.getPricePoints().get(1).isCancellationUsage()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getTierName() ).as(" catalogService.getPricePoints().get(1).getTierName()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPromoPrecode() ).as(" catalogService.getPricePoints().get(1).getPromoPrecode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getUniquePromoCode() ).as(" catalogService.getPricePoints().get(1).getUniquePromoCode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPromoUniqueCode() ).as(" catalogService.getPricePoints().get(1).getPromoUniqueCode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getNextCycleDiscount() ).as(" catalogService.getPricePoints().get(1).getNextCycleDiscount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getHasHistoricPricePointFlag() ).as(" catalogService.getPricePoints().get(1).getHasHistoricPricePointFlag()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isIsForRenewal() ).as(" catalogService.getPricePoints().get(1).isIsForRenewal()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getTaxRateAsDouble() ).as(" catalogService.getPricePoints().get(1).getTaxRateAsDouble()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getAffiliateID() ).as(" catalogService.getPricePoints().get(1).getAffiliateID()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPartnerId() ).as(" catalogService.getPricePoints().get(1).getPartnerId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getTariff() ).as(" catalogService.getPricePoints().get(1).getTariff()" ).isEqualTo("*");
        softly.assertThat(catalogService.getPricePoints().get(1).getAggregatorId() ).as(" catalogService.getPricePoints().get(1).getAggregatorId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).isForcePurchaseFlow() ).as(" catalogService.getPricePoints().get(1).isForcePurchaseFlow()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getReceipientMsisdn() ).as(" catalogService.getPricePoints().get(1).getReceipientMsisdn()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getProductCode() ).as(" catalogService.getPricePoints().get(1).getProductCode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getMerchantName() ).as(" catalogService.getPricePoints().get(1).getMerchantName()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getInvoiceText() ).as(" catalogService.getPricePoints().get(1).getInvoiceText()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).isReIssueEnabled() ).as(" catalogService.getPricePoints().get(1).isReIssueEnabled()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).isReIssueFlagPresent() ).as(" catalogService.getPricePoints().get(1).isReIssueFlagPresent()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getShortPackageId() ).as(" catalogService.getPricePoints().get(1).getShortPackageId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getHistoryStartDate() ).as(" catalogService.getPricePoints().get(1).getHistoryStartDate()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getVendorId() ).as(" catalogService.getPricePoints().get(1).getVendorId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).isIsForNextPaymentAmount() ).as(" catalogService.getPricePoints().get(1).isIsForNextPaymentAmount()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getRenewalPreRate() ).as(" catalogService.getPricePoints().get(1).getRenewalPreRate()" ).isEqualTo(new Double(-1.0)) ;
        softly.assertThat(catalogService.getPricePoints().get(1).isOverrideDisallowPreRateFlag() ).as(" catalogService.getPricePoints().get(1).isOverrideDisallowPreRateFlag()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getContentCategory() ).as(" catalogService.getPricePoints().get(1).getContentCategory()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPartnerUrl() ).as(" catalogService.getPricePoints().get(1).getPartnerUrl()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPartnerContactInfo() ).as(" catalogService.getPricePoints().get(1).getPartnerContactInfo()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPartnerEmail() ).as(" catalogService.getPricePoints().get(1).getPartnerEmail()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getPartnerName() ).as(" catalogService.getPricePoints().get(1).getPartnerName()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint() ).as(" catalogService.getPricePoints().get(1).getSubRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint() ).as(" catalogService.getPricePoints().get(1).getPPtRenewalCounterToLinkedPricepoint()" ).isEqualTo(-1) ;
        softly.assertThat(catalogService.getPricePoints().get(1).getSubRenewalPricepointId() ).as(" catalogService.getPricePoints().get(1).getSubRenewalPricepointId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getLinkPricepointId() ).as(" catalogService.getPricePoints().get(1).getLinkPricepointId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getSubPurchaseTransactionTrial() ).as(" catalogService.getPricePoints().get(1).getSubPurchaseTransactionTrial()" ).isFalse() ;
        softly.assertThat(catalogService.getPricePoints().get(1).getDiscardHiddenInactivePricepoints() ).as(" catalogService.getPricePoints().get(1).getDiscardHiddenInactivePricepoints()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints() ).as(" catalogService.getPricePoints().get(1).isDiscardMiddleAdvancedPricepoints()" ).isFalse() ;
//        softly.assertThat(catalogService.getPricePoints().get(1).getExtIdentifier1() ).as(" catalogService.getPricePoints().get(1).getExtIdentifier1()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getExtIdentifier2() ).as(" catalogService.getPricePoints().get(1).getExtIdentifier2()" ).isNull();
//        softly.assertThat(catalogService.getPricePoints().get(1).getExtIdentifier3() ).as(" catalogService.getPricePoints().get(1).getExtIdentifier3()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getAccessChannel() ).as(" catalogService.getPricePoints().get(1).getAccessChannel()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getPurchaseChannel() ).as(" catalogService.getPricePoints().get(1).getPurchaseChannel()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getDeviceID() ).as(" catalogService.getPricePoints().get(1).getDeviceID()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getLocal() ).as(" catalogService.getPricePoints().get(1).getLocal()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getMsisdn() ).as(" catalogService.getPricePoints().get(1).getMsisdn()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getLanguageLocale() ).as(" catalogService.getPricePoints().get(1).getLanguageLocale()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getLanguageCode() ).as(" catalogService.getPricePoints().get(1).getLanguageCode()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getExternalField1() ).as(" catalogService.getPricePoints().get(1).getExternalField1()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getExternalField2() ).as(" catalogService.getPricePoints().get(1).getExternalField2()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getExternalTransId() ).as(" catalogService.getPricePoints().get(1).getExternalTransId()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getActiveSubscriptions() ).as(" catalogService.getPricePoints().get(1).getActiveSubscriptions()" ).isNull();
        softly.assertThat(catalogService.getPricePoints().get(1).getCsrId() ).as(" catalogService.getPricePoints().get(1).getCsrId()" ).isNull();
        softly.assertThat(catalogService.isReserveOnly() ).as(" catalogService.isReserveOnly()" ).isFalse() ;
        softly.assertThat(catalogService.getPricingText1() ).as(" catalogService.getPricingText1()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricingText1() ).as(" catalogService.getPricingText1()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricingText2() ).as(" catalogService.getPricingText2()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPricingText2() ).as(" catalogService.getPricingText2()" ).isEqualTo("");
        softly.assertThat(catalogService.getPricePoint() ).as(" catalogService.getPricePoint()" ).isNull();
        softly.assertThat(catalogService.getTaxCode() ).as(" catalogService.getTaxCode()" ).isEqualTo("TAX");
        softly.assertThat(catalogService.getDescription() ).as(" catalogService.getDescription()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getDescription() ).as(" catalogService.getDescription()" ).isEqualTo("");
        softly.assertThat(catalogService.getContentCategory() ).as(" catalogService.getContentCategory()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getContentCategory() ).as(" catalogService.getContentCategory()" ).isEqualTo("");
        softly.assertThat(catalogService.getUrl() ).as(" catalogService.getUrl()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getUrl() ).as(" catalogService.getUrl()" ).isEqualTo("");
        softly.assertThat(catalogService.getSalesModel() ).as(" catalogService.getSalesModel()" ).isEqualTo("Reseller");
        softly.assertThat(catalogService.isReturnAllCatalogueServicesInfo() ).as(" catalogService.isReturnAllCatalogueServicesInfo()" ).isTrue() ;
        softly.assertThat(catalogService.isDefaultService() ).as(" catalogService.isDefaultService()" ).isFalse() ;
//        softly.assertThat(catalogService.getPriorityServiceRevenueSharePartner() ).as(" catalogService.getPriorityServiceRevenueSharePartner()" ).isNull();
//        softly.assertThat(catalogService.isUniqueServiceClass() ).as(" catalogService.isUniqueServiceClass()" ).isFalse() ;
        softly.assertThat(catalogService.getIndirectValue() ).as(" catalogService.getIndirectValue()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getIndirectValue() ).as(" catalogService.getIndirectValue()" ).isEqualTo("");
        softly.assertThat(catalogService.getIndirectValueFormat() ).as(" catalogService.getIndirectValueFormat()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getIndirectValueFormat() ).as(" catalogService.getIndirectValueFormat()" ).isEqualTo("");
        softly.assertThat(catalogService.getPromoValue() ).as(" catalogService.getPromoValue()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPromoValue() ).as(" catalogService.getPromoValue()" ).isEqualTo("");
        softly.assertThat(catalogService.getPromoValueFormat() ).as(" catalogService.getPromoValueFormat()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getPromoValueFormat() ).as(" catalogService.getPromoValueFormat()" ).isEqualTo("");
        softly.assertThat(catalogService.getContentSubCategory() ).as(" catalogService.getContentSubCategory()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getContentSubCategory() ).as(" catalogService.getContentSubCategory()" ).isEqualTo("");
        softly.assertThat(catalogService.getContentItem() ).as(" catalogService.getContentItem()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getContentItem() ).as(" catalogService.getContentItem()" ).isEqualTo("");
        softly.assertThat(catalogService.getDeliveryMechanism() ).as(" catalogService.getDeliveryMechanism()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getDeliveryMechanism() ).as(" catalogService.getDeliveryMechanism()" ).isEqualTo("");
        softly.assertThat(catalogService.getProductCategory() ).as(" catalogService.getProductCategory()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getProductCategory() ).as(" catalogService.getProductCategory()" ).isEqualTo("");
        softly.assertThat(catalogService.getProductSubCategory1() ).as(" catalogService.getProductSubCategory1()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getProductSubCategory1() ).as(" catalogService.getProductSubCategory1()" ).isEqualTo("");
        softly.assertThat(catalogService.getProductSubCategory2() ).as(" catalogService.getProductSubCategory2()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getProductSubCategory2() ).as(" catalogService.getProductSubCategory2()" ).isEqualTo("");
        softly.assertThat(catalogService.getProvisioningTag() ).as(" catalogService.getProvisioningTag()" ).isEqualTo("N/A");
        softly.assertThat(catalogService.getProvisioningSystem() ).as(" catalogService.getProvisioningSystem()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getProvisioningSystem() ).as(" catalogService.getProvisioningSystem()" ).isEqualTo("");
        softly.assertThat(catalogService.getUsageId() ).as(" catalogService.getUsageId()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getUsageId() ).as(" catalogService.getUsageId()" ).isEqualTo("");
        softly.assertThat(catalogService.getServiceCategory() ).as(" catalogService.getServiceCategory()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getServiceCategory() ).as(" catalogService.getServiceCategory()" ).isEqualTo("");
        softly.assertThat(catalogService.getDealName() ).as(" catalogService.getDealName()" ).isNull();
        softly.assertThat(catalogService.getDistributionChannel() ).as(" catalogService.getDistributionChannel()" ).isNull();
        softly.assertThat(catalogService.getHighVolumeInterfaceLevel() ).as(" catalogService.getHighVolumeInterfaceLevel()" ).isEqualTo(998) ;
        softly.assertThat(catalogService.isHighVolumeInterface() ).as(" catalogService.isHighVolumeInterface()" ).isFalse() ;
        softly.assertThat(catalogService.getServiceRevenueSharePartnerNum() ).as(" catalogService.getServiceRevenueSharePartnerNum()" ).isEqualTo(1) ;
        softly.assertThat(catalogService.getRateCardPartners() ).as(" catalogService.getRateCardPartners()" ).isNull();
        softly.assertThat(catalogService.isUsageAllowedBeingProvisionedSub() ).as(" catalogService.isUsageAllowedBeingProvisionedSub()" ).isFalse() ;
        softly.assertThat(catalogService.isGlobalHandler() ).as(" catalogService.isGlobalHandler()" ).isFalse() ;
        softly.assertThat(catalogService.isGlobalHandlerNotification() ).as(" catalogService.isGlobalHandlerNotification()" ).isFalse() ;
        softly.assertThat(catalogService.getProductWholesalePrice() ).as(" catalogService.getProductWholesalePrice()" ).isNull();
        softly.assertThat(catalogService.getProductSelfRegulation() ).as(" catalogService.getProductSelfRegulation()" ).isNull();
        softly.assertThat(catalogService.isVolumeService() ).as(" catalogService.isVolumeService()" ).isFalse() ;
        softly.assertThat(catalogService.getProductFk() ).as(" catalogService.getProductFk()" ).isNull();
        softly.assertThat(catalogService.isServiceShareOverride() ).as(" catalogService.isServiceShareOverride()" ).isFalse() ;
        softly.assertThat(catalogService.isExpiredPackageService() ).as(" catalogService.isExpiredPackageService()" ).isFalse() ;
        softly.assertThat(catalogService.getFixedUsageAmount() ).as(" catalogService.getFixedUsageAmount()" ).isEqualTo(new Double(0.0)) ;
        softly.assertThat(catalogService.getHasExpress() ).as(" catalogService.getHasExpress()" ).isFalse() ;
        softly.assertThat(catalogService.getHasDynamicDefault() ).as(" catalogService.getHasDynamicDefault()" ).isFalse() ;
        softly.assertThat(catalogService.getHasSuperPackage() ).as(" catalogService.getHasSuperPackage()" ).isFalse() ;
        softly.assertThat(catalogService.isReturnTrialOptionsOnly() ).as(" catalogService.isReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(catalogService.getServiceClass() ).as(" catalogService.getServiceClass()" ).isNull();
// java.util.HashMap
        softly.assertThat(catalogService.isReIssuePermittedFlag() ).as(" catalogService.isReIssuePermittedFlag()" ).isFalse() ;
        softly.assertThat(catalogService.isProvisionOnUsage() ).as(" catalogService.isProvisionOnUsage()" ).isFalse() ;
        softly.assertThat(catalogService.getChargeableBy() ).as(" catalogService.getChargeableBy()" ).isEqualTo("Currency and Custom Credits");
        softly.assertThat(catalogService.isMicroService() ).as(" catalogService.isMicroService()" ).isFalse() ;
        softly.assertThat(catalogService.getSuperPackageIds() ).as(" catalogService.getSuperPackageIds()" ).isNull();
        softly.assertThat(catalogService.getmExternalServPricePlan() ).as(" catalogService.getmExternalServPricePlan()" ).isNull();
        softly.assertThat(catalogService.ismRefundable() ).as(" catalogService.ismRefundable()" ).isTrue() ;
        softly.assertThat(catalogService.ismReturnTrialOptionsOnly() ).as(" catalogService.ismReturnTrialOptionsOnly()" ).isFalse() ;
        softly.assertThat(catalogService.isUseRateCard() ).as(" catalogService.isUseRateCard()" ).isFalse() ;
        softly.assertThat(catalogService.getInternalPartner() ).as(" catalogService.getInternalPartner()" ).isNull();
        softly.assertThat(catalogService.getServiceType() ).as(" catalogService.getServiceType()" ).isNullOrEmpty();
        softly.assertThat(catalogService.getServiceType() ).as(" catalogService.getServiceType()" ).isEqualTo("");

        //TODO Empty RevenueSharePartners
        softly.assertThat(catalogService.getServiceRevenueSharePartners().length).as(" catalogService.getServiceRevenueSharePartners().length").isEqualTo(1);

        System.out.println("Length = " + catalogService.getServiceRevenueSharePartners().length);
//        assertEquals(1, catalogService.getServiceRevenueSharePartners().length);

//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getName() ).as(" catalogService.getServiceRevenueSharePartners()[0].getName()" ).isEqualTo("P001");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getKey() ).as(" catalogService.getServiceRevenueSharePartners()[0].getKey()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getId() ).as(" catalogService.getServiceRevenueSharePartners()[0].getId()" ).isEqualTo("P001");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getPurchaseChannel() ).as(" catalogService.getServiceRevenueSharePartners()[0].getPurchaseChannel()" ).isEqualTo("*");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getModel() ).as(" catalogService.getServiceRevenueSharePartners()[0].getModel()" ).isEqualTo("SINGLE");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getPriorityFlag() ).as(" catalogService.getServiceRevenueSharePartners()[0].getPriorityFlag()" ).isEqualTo("N");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].isPriorityPartner() ).as(" catalogService.getServiceRevenueSharePartners()[0].isPriorityPartner()" ).isFalse() ;
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getWhTaxAmt() ).as(" catalogService.getServiceRevenueSharePartners()[0].getWhTaxAmt()" ).isNullOrEmpty();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getWhTaxAmt() ).as(" catalogService.getServiceRevenueSharePartners()[0].getWhTaxAmt()" ).isEqualTo("");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getWhTaxOffset() ).as(" catalogService.getServiceRevenueSharePartners()[0].getWhTaxOffset()" ).isEqualTo("Y");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getFixedPayment() ).as(" catalogService.getServiceRevenueSharePartners()[0].getFixedPayment()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getFixedPaymentFlag() ).as(" catalogService.getServiceRevenueSharePartners()[0].getFixedPaymentFlag()" ).isEqualTo("N");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getKey() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getKey()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getSharePercentage() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getSharePercentage()" ).isEqualTo("100");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getDirectFixedAmount() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getDirectFixedAmount()" ).isNullOrEmpty();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getDirectFixedAmount() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getDirectFixedAmount()" ).isEqualTo("");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getIndirectFixedAmount() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getIndirectFixedAmount()" ).isNullOrEmpty();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getIndirectFixedAmount() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getIndirectFixedAmount()" ).isEqualTo("");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getIndirectFixedAmountPromo() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getIndirectFixedAmountPromo()" ).isNullOrEmpty();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getIndirectFixedAmountPromo() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getIndirectFixedAmountPromo()" ).isEqualTo("");
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getMinimumThreshold() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getMinimumThreshold()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getMaximumThreshold() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getMaximumThreshold()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getPurchaseChannel() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevenueShareTiers().get(0).getPurchaseChannel()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevThreshFormat() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevThreshFormat()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartners()[0].getRevThreshCounterReset() ).as(" catalogService.getServiceRevenueSharePartners()[0].getRevThreshCounterReset()" ).isNull();

        //TODO Empty ServiceRevenueSharePartnersPurchaseCh
        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh().length ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh() length" ).isEqualTo(1);

//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getName() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getName()" ).isEqualTo("P001");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getKey() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getKey()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getId() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getId()" ).isEqualTo("P001");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getPurchaseChannel() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getPurchaseChannel()" ).isEqualTo("*");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getModel() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getModel()" ).isEqualTo("SINGLE");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getPriorityFlag() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getPriorityFlag()" ).isEqualTo("N");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].isPriorityPartner() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].isPriorityPartner()" ).isFalse() ;
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getWhTaxAmt() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getWhTaxAmt()" ).isNullOrEmpty();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getWhTaxAmt() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getWhTaxAmt()" ).isEqualTo("");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getWhTaxOffset() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getWhTaxOffset()" ).isEqualTo("Y");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getFixedPayment() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getFixedPayment()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getFixedPaymentFlag() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getFixedPaymentFlag()" ).isEqualTo("N");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getKey() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getKey()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getSharePercentage() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getSharePercentage()" ).isEqualTo("100");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getDirectFixedAmount() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getDirectFixedAmount()" ).isNullOrEmpty();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getDirectFixedAmount() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getDirectFixedAmount()" ).isEqualTo("");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getIndirectFixedAmount() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getIndirectFixedAmount()" ).isNullOrEmpty();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getIndirectFixedAmount() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getIndirectFixedAmount()" ).isEqualTo("");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getIndirectFixedAmountPromo() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getIndirectFixedAmountPromo()" ).isNullOrEmpty();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getIndirectFixedAmountPromo() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getIndirectFixedAmountPromo()" ).isEqualTo("");
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getMinimumThreshold() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getMinimumThreshold()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getMaximumThreshold() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getMaximumThreshold()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getPurchaseChannel() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevenueShareTiers().get(0).getPurchaseChannel()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevThreshFormat() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevThreshFormat()" ).isNull();
//        softly.assertThat(catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevThreshCounterReset() ).as(" catalogService.getServiceRevenueSharePartnersPurchaseCh()[0].getRevThreshCounterReset()" ).isNull();


        softly.assertAll();
    }

}
