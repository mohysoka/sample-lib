/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.kai.lib.responses;

import co.id.kai.lib.location.City;
import co.id.kai.lib.location.Province;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import co.id.kai.lib.PageImplBean;
import java.util.List;

/**
 *
 * @author Mo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseResource {
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private String err_code;
    private String msg;
//----------------Model & List Model-------------------------------------------//
    
    @JsonInclude(Include.NON_NULL)
    private PageImplBean<Province> pageprovince;
    @JsonInclude(Include.NON_NULL)
    private Province province;
    @JsonInclude(Include.NON_NULL)
    private List<Province> listprovince;
    
    @JsonInclude(Include.NON_NULL)
    private PageImplBean<City> pagecity;
    @JsonInclude(Include.NON_NULL)
    private City city;
    @JsonInclude(Include.NON_NULL)
    private List<City> listcity;
    
    
//----------------------------------------------------------------------------//
    
    public ResponseResource() { }

    public ResponseResource(String err_code, String msg) {
        this.err_code = err_code;
        this.msg = msg;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageImplBean<Province> getPageprovince() {
        return pageprovince;
    }

    public void setPageprovince(PageImplBean<Province> pageprovince) {
        this.pageprovince = pageprovince;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Province> getListprovince() {
        return listprovince;
    }

    public void setListprovince(List<Province> listprovince) {
        this.listprovince = listprovince;
    }

    public PageImplBean<City> getPagecity() {
        return pagecity;
    }

    public void setPagecity(PageImplBean<City> pagecity) {
        this.pagecity = pagecity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<City> getListcity() {
        return listcity;
    }

    public void setListcity(List<City> listcity) {
        this.listcity = listcity;
    }

}

