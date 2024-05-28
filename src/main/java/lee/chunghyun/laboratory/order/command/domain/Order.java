package lee.chunghyun.laboratory.order.command.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_agency_id", nullable = false, length = 30)
    private String orderAgencyId;

    @Column(name = "manage_order_agency_id", nullable = false, length = 30)
    private String manageOrderAgencyId;

    @Column(name = "order_agency_store_id", length = 100)
    private String orderAgencyStoreId;

    @Column(name = "store_id", nullable = false)
    private Integer storeId;

    @Column(name = "order_agency_order_id", length = 100)
    private String orderAgencyOrderId;

    @Column(name = "order_agency_daily_order_id", length = 10)
    private String orderAgencyDailyOrderId;

    @Column(name = "order_type", nullable = false, length = 50)
    private String orderType;

    @Column(name = "base_type", nullable = false, length = 50)
    private String baseType;

    @Column(name = "serve_type", nullable = false, length = 30)
    private String serveType;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @Column(name = "actual_pay_price", nullable = false)
    private Integer actualPayPrice;

    @Column(name = "prepaid_price", nullable = false, default = 0)
    private Integer prepaidPrice;

    @Column(name = "total_pay_price", nullable = false)
    private Integer totalPayPrice;

    @Column(name = "prepaid_method", length = 30)
    private String prepaidMethod;

    @Column(name = "payment_cash_price", nullable = false)
    private Integer paymentCashPrice;

    @Column(name = "payment_card_price", nullable = false)
    private Integer paymentCardPrice;

    @Column(name = "tax_free_pay_price", nullable = false, default = 0)
    private Integer taxFreePayPrice;

    @Column(name = "orderer_name", length = 200)
    private String ordererName;

    @Column(name = "orderer_phone", length = 200)
    private String ordererPhone;

    @Column(name = "orderer_phone_last", length = 4)
    private String ordererPhoneLast;

    @Column(name = "receiver_name", length = 200)
    private String receiverName;

    @Column(name = "receiver_phone", length = 200)
    private String receiverPhone;

    @Column(name = "receiver_phone_last", length = 4)
    private String receiverPhoneLast;

    @Column(name = "store_order_memo", length = 250)
    private String storeOrderMemo;

    @Column(name = "orderer_order_memo", length = 250)
    private String ordererOrderMemo;

    @Column(name = "pickup_location")
    @ElementCollection
    private List<String> pickupLocation;

    @Column(name = "pickup_jibun_address", length = 1000)
    private String pickupJibunAddress;

    @Column(name = "pickup_road_address", length = 1000)
    private String pickupRoadAddress;

    @Column(name = "pickup_address_detail", length = 700)
    private String pickupAddressDetail;

    @Column(name = "pickup_name", length = 200)
    private String pickupName;

    @Column(name = "pickup_phone", length = 200)
    private String pickupPhone;

    @Column(name = "pickup_phone_last", length = 4)
    private String pickupPhoneLast;

    @Column(name = "drop_location")
    @ElementCollection
    private List<String> dropLocation;

    @Column(name = "drop_jibun_address", length = 1000)
    private String dropJibunAddress;

    @Column(name = "drop_road_address", length = 1000)
    private String dropRoadAddress;

    @Column(name = "drop_address_detail", length = 700)
    private String dropAddressDetail;

    @Column(name = "drop_entrance_password", length = 150)
    private String dropEntrancePassword;

    @Column(name = "pickup_guide", length = 1600)
    private String pickupGuide;

    @Column(name = "drop_guide", length = 1600)
    private String dropGuide;

    @Column(name = "cancel_reason", length = 250)
    private String cancelReason;

    @Column(name = "cancel_type", length = 50)
    private String cancelType;

    @Column(name = "pickup_wish_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickupWishAt;

    @Column(name = "drop_wish_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dropWishAt;

    @Column(name = "reserved_order_display_time")
    private Integer reservedOrderDisplayTime;

    @Column(name = "is_reservation", nullable = false)
    private Boolean isReservation;

    @Column(name = "is_untact", nullable = false)
    private Boolean isUntact;

    @Column(name = "order_agency_order_created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderAgencyOrderCreatedAt;

    @Column(name = "order_channel", length = 30)
    private String orderChannel;

    @Column(name = "order_closed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderClosedAt;

    @Column(name = "store_drop_expected_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date storeDropExpectedAt;

    @Column(name = "is_permanently_masked")
    private Boolean isPermanentlyMasked;

    @Column(name = "duplicate_key", nullable = false, default = 0)
    private Double duplicateKey;

    @Column(name = "sale_region_id", nullable = false, default = 0)
    private Integer saleRegionId;

    @Column(name = "bundle_delivery_count")
    private Integer bundleDeliveryCount;

    @Column(name = "has_alcoholic_beverage", nullable = false)
    private Boolean hasAlcoholicBeverage;

    @Column(name = "pickup_id", length = 100)
    private String pickupId;

    // Relationships
    @OneToMany(mappedBy = "order")
    private List<Delivery> deliveries;

    @OneToMany(mappedBy = "order")
    private List<OrderStatus> orderStatuses;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;

    @OneToMany(mappedBy = "order")
    private List<Payment> payments;

    @OneToOne(mappedBy = "order")
    private OrderDropAddress orderDropAddress;

    @OneToOne(mappedBy = "order")
    private OrderPickupAddress orderPickupAddress;

    @OneToOne(mappedBy = "order")
    private OrderAgencyRelativeOrder orderAgencyRelativeOrder;

    @OneToOne(mappedBy = "order")
    private ReorderRelation reorderRelation;

    @OneToMany(mappedBy = "order")
    private List<OrderTimeline> orderTimelines;

    @ManyToOne
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;

    @ManyToOne
    @JoinColumn(name = "view_store_id", insertable = false, updatable = false)
    private ViewStore viewStore;

    @ManyToOne
    @JoinColumn(name = "order_agency_id", insertable = false, updatable = false)
    private OrderAgency orderAgency;

    @ManyToOne
    @JoinColumn(name = "manage_order_agency_id", insertable = false, updatable = false)
    private OrderAgency manageOrderAgency;

    @OneToMany(mappedBy = "order")
    private List<PurchaseHistory> purchaseHistories;

    @OneToMany(mappedBy = "order")
    private List<SaleHistory> saleHistories;

    @OneToMany(mappedBy = "order")
    private List<OrderPreparedNotificationHistory> orderPreparedNotificationHistories;
}
