package com.linkcar.common.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统资源
 */
@Configuration
@ConfigurationProperties(prefix = "mishi")
public class DomainUrlUtil {

    private String wxConf;

    private String urlResources;
    private String staticResources;
    private String imageResources;

    private String urlLog;
    private String urlPcIndex;
    private String urlPcItem;
    private String urlPcOrder;
    private String urlPcUser;
    private String urlPcShop;

    private String urlH5Index;
    private String urlH5Item;
    private String urlH5Order;
    private String urlH5User;
    private String urlH5Shop;
    private String urlH5Static;

    private String cookieDomain;
    private String cookieName;
    private String frontUrl;
    private String h5Url;
    private String searchSolrUrl;
    private String searchSolrServer;
    private String pomLogFile;
    private String pomLogLevel;

    public String getWxConf() {
        return wxConf;
    }

    public void setWxConf(String wxConf) {
        this.wxConf = wxConf;
    }

    public String getUrlResources() {
        return urlResources;
    }

    public void setUrlResources(String urlResources) {
        this.urlResources = urlResources;
    }

    public String getStaticResources() {
        return staticResources;
    }

    public void setStaticResources(String staticResources) {
        this.staticResources = staticResources;
    }

    public String getImageResources() {
        return imageResources;
    }

    public void setImageResources(String imageResources) {
        this.imageResources = imageResources;
    }

    public String getCookieDomain() {
        return cookieDomain;
    }

    public void setCookieDomain(String cookieDomain) {
        this.cookieDomain = cookieDomain;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getFrontUrl() {
        return frontUrl;
    }

    public void setFrontUrl(String frontUrl) {
        this.frontUrl = frontUrl;
    }

    public String getH5Url() {
        return h5Url;
    }

    public void setH5Url(String h5Url) {
        this.h5Url = h5Url;
    }

    public String getSearchSolrUrl() {
        return searchSolrUrl;
    }

    public void setSearchSolrUrl(String searchSolrUrl) {
        this.searchSolrUrl = searchSolrUrl;
    }

    public String getSearchSolrServer() {
        return searchSolrServer;
    }

    public void setSearchSolrServer(String searchSolrServer) {
        this.searchSolrServer = searchSolrServer;
    }

    public String getPomLogFile() {
        return pomLogFile;
    }

    public void setPomLogFile(String pomLogFile) {
        this.pomLogFile = pomLogFile;
    }

    public String getPomLogLevel() {
        return pomLogLevel;
    }

    public void setPomLogLevel(String pomLogLevel) {
        this.pomLogLevel = pomLogLevel;
    }

    public String getUrlLog() {
        return urlLog;
    }

    public void setUrlLog(String urlLog) {
        this.urlLog = urlLog;
    }

    public String getUrlPcIndex() {
        return urlPcIndex;
    }

    public void setUrlPcIndex(String urlPcIndex) {
        this.urlPcIndex = urlPcIndex;
    }

    public String getUrlPcItem() {
        return urlPcItem;
    }

    public void setUrlPcItem(String urlPcItem) {
        this.urlPcItem = urlPcItem;
    }

    public String getUrlPcOrder() {
        return urlPcOrder;
    }

    public void setUrlPcOrder(String urlPcOrder) {
        this.urlPcOrder = urlPcOrder;
    }

    public String getUrlPcUser() {
        return urlPcUser;
    }

    public void setUrlPcUser(String urlPcUser) {
        this.urlPcUser = urlPcUser;
    }

    public String getUrlPcShop() {
        return urlPcShop;
    }

    public void setUrlPcShop(String urlPcShop) {
        this.urlPcShop = urlPcShop;
    }

    public String getUrlH5Index() {
        return urlH5Index;
    }

    public void setUrlH5Index(String urlH5Index) {
        this.urlH5Index = urlH5Index;
    }

    public String getUrlH5Item() {
        return urlH5Item;
    }

    public void setUrlH5Item(String urlH5Item) {
        this.urlH5Item = urlH5Item;
    }

    public String getUrlH5Order() {
        return urlH5Order;
    }

    public void setUrlH5Order(String urlH5Order) {
        this.urlH5Order = urlH5Order;
    }

    public String getUrlH5User() {
        return urlH5User;
    }

    public void setUrlH5User(String urlH5User) {
        this.urlH5User = urlH5User;
    }

    public String getUrlH5Shop() {
        return urlH5Shop;
    }

    public void setUrlH5Shop(String urlH5Shop) {
        this.urlH5Shop = urlH5Shop;
    }

    public String getUrlH5Static() {
        return urlH5Static;
    }

    public void setUrlH5Static(String urlH5Static) {
        this.urlH5Static = urlH5Static;
    }

    /**
     * cors 跨域获取 Cookie
     *
     * @param request
     * @param response
     */
    public void corsCookie(HttpServletRequest request, HttpServletResponse response) {
        String origin = request.getHeader("Origin");
        if (origin != null && origin.contains(cookieDomain)) {
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Credentials", "true");
        }
    }

}
