package com.linkcar.common.utils;

/**
 * 商城存入redis缓存的key常量定义，固定key或者key前缀等。（每个可以必须标明注释、且绝对不可重复）
 */
public class RedisConstants {

    /**
     * 过期时间：24小时
     */
    public static final long EXPIRE_24_HOURS = 24 * 60 * 60;
    /**
     * 过期时间：60分钟
     */
    public static final long EXPIRE_60_MINUTES = 60 * 60;
    /**
     * 过期时间：30分钟
     */
    public static final long EXPIRE_30_MINUTES = 30 * 60;
    /**
     * 过期时间：2小时
     */
    public static final long EXPIRE_2_HOURS = 2 * 60 * 60;
    /**
     * 过期时间：30天
     */
    public static final long EXPIRE_30_DAY = 30 * 24 * 60 * 60;
    /**
     * 过期时间：1分钟
     */
    public static final long EXPIRE_1_MINUTES = 60;
    /**
     * 过期时间：2分钟
     */
    public static final long EXPIRE_2_MINUTES = 60 * 2;

    /**
     * redis设置成功返回值：OK
     */
    public static final String SUCCESS = "OK";

    /**
     * front和h5端用户session信息存入redis的key前缀（front和h5的规则一致）
     */
    public static final String SESSION_CUSTOMER_PRE = "session_customer_id:";

    /**
     * admin端用户session信息存入redis的key前缀（未使用）
     */
    public static final String SESSION_PLATFORM_PRE = "session_platform_id:";

    /**
     * seller端用户session信息存入redis的key前缀（未使用）
     */
    public static final String SESSION_SUPPLIER_PRE = "session_supplier_id:";

    /**
     * 验证码key
     */
    public static final String VERIFY_NUMBER_PRE = "verify_number:";

    /**
     * 找回支付密码手机验证码前缀
     */
    public static final String BLT_SMS_CODE_PRE = "blt_sms_code:";

    /**
     * 支付密码用户发送/接收短信最大数量
     */
    public static final String BLT_CODE_COUNT_PRE = "blt_code_count:";

    /**
     * 支付密码手机验证成功
     */
    public static final String BLT_VALIDATE_SUCCESS_PRE = "blt_mobile_valid_success:";

    /**
     * 用户注册手机验证码前缀
     */
    public static final String REG_SMS_CODE_PRE = "reg_sms_code:";

    /**
     * 用户注册手机验证码前缀
     */
    public static final String REG_CODE_COUNT_PRE = "reg_code_count:";

    /**
     * 所有省份前缀
     */
    public static final String REGIONS_ALL_PROVINCE = "regions_all_province";

    /**
     * 子地区前缀
     */
    public static final String REGIONS_CHILEREN_PRE = "regions_chileren:";

    /**
     * 父地区前缀
     */
    public static final String REGIONS_PARENT_PRE = "regions_parent:";

    /**
     * 地区缓存前缀
     */
    public static final String REGIONS_PRE = "regions:";

    /**
     * 所有地区缓存
     */
    public static final String REGIONS_ALL = "regions_all";

    /**
     * 数据字典
     */
    public static final String CODE_MASTER_PRE = "code_master:";

    /**
     * PC首页缓存KEY
     */
    public static final String INDEX_HTML_PC = "index_html_pc";

    /**
     * 移动端首页缓存KEY
     */
    public static final String INDEX_HTML_M = "index_html_m";

    /**
     * 微信access-token
     */
    public static final String WX_ACCESS_TOKEN = "wx_access_token";

    /**
     * 前台分类key
     */
    public static final String CUSTOMER_CATE = "customer_cate";

    /**
     * 前台商家分类key
     */
    public static final String CUSTOMER_SELLER_CATE_PRE = "customer_seller_cate:";

    /**
     * 用户购物车信息前缀(删除方法使用delByPre，所有key的前缀不能与此前缀相同或以此前缀开头)
     */
    public static final String MEMBER_CART_PRE = "member_cart:";

    /**
     * 集合竞价前缀(删除方法使用delByPre，所有key的前缀不能与此前缀相同或以此前缀开头)
     */
    public static final String BIDDING_BANNERS_PRE = "bidding_banners:";

    /**
     * 集合竞价分类
     */
    public static final String BIDDING_TYPE_ALL = "bidding_type_all";

    /**
     * 限时抢购首页轮播图前缀(删除方法使用delByPre，所有key的前缀不能与此前缀相同或以此前缀开头)
     */
    public static final String FLASH_BANNERS_PRE = "falsh_banners:";

    /**
     * 团购首页轮播图前缀(删除方法使用delByPre，所有key的前缀不能与此前缀相同或以此前缀开头)
     */
    public static final String GROUP_BANNERS_PRE = "group_banners:";

    /**
     * 团购分类
     */
    public static final String GROUP_TYPE_ALL = "group_type_all";

    /**
     * 积分首页轮播图前缀(删除方法使用delByPre，所有key的前缀不能与此前缀相同或以此前缀开头)
     */
    public static final String INTEGRAL_BANNERS_PRE = "integral_banners:";

    /**
     * 积分分类
     */
    public static final String INTEGRAL_TYPE_ALL = "integral_type_all";

    /**
     * 快递公司
     */
    public static final String COURIER_COMPANY_ALL = "courier_company_all";

    /**
     * 商家PC首页信息前缀
     */
    public static final String SELLER_INDEXS_PC_PRE = "seller_indexs_pc:";

    /**
     * 商家PC首页轮播图前缀
     */
    public static final String SELLER_BANNERS_PC_PRE = "seller_banners_pc:";

    /**
     * 商家移动首页轮播图前缀
     */
    public static final String SELLER_BANNERS_MOBILE_PRE = "seller_banners_mobile:";

    /**
     * 文章分类
     */
    public static final String NEWS_TYPE_FOR_ARTICLE = "news_type_for_article";

    /**
     * 文章VO前缀
     */
    public static final String NEWS_PRE = "news:";

    /**
     * 客服QQ前缀
     */
    public static final String SELLER_QQ_PRE = "seller_qq:";

    /**
     * PC公共头html缓存KEY
     */
    public static final String COMMON_HEAD_HTML_PC = "common_head_html_pc";

    /**
     * PC公共尾html缓存KEY
     */
    public static final String COMMON_FOOTER_HTML_PC = "common_footer_html_pc";

    /**
     * 微信H5支付预支付交易会话标识
     */
    public static final String WX_H5_PREPAY_ID_PRE = "wx_h5_prepay_id:";

    /**
     * 微信用户标识前缀
     */
    public static final String WX_OPENID_SESSIONID_PRE = "wx_openid_sessionId:";

    /**
     * 商品预锁库存信息
     */
    public static final String ORDER_QUANTITY_LOCK = "order_quantity_lock:";
}
