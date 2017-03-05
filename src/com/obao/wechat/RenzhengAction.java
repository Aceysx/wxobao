package com.obao.wechat;

import com.obao.user.entity.Cart;
import com.obao.user.entity.User;
import com.obao.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Acey on 2017/1/8.
 */
public class RenzhengAction extends ActionSupport {
    private User user;
    private IUserService userService;
    private String openid;
    private final String APPID = "wx3ef4e6cc97e27e16";
    private final String SECRET = "038c92a2c0e127fa52f06e3919af0708";
    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;
    private String code;
    private String get_access_token_url="https://api.weixin.qq.com/sns/oauth2/access_token?" +
            "appid=" +APPID+
            "&secret=" +SECRET+
            "&code=CODE&grant_type=authorization_code";
    private String get_userinfo="https://api.weixin.qq.com/sns/userinfo?" +
            "access_token=ACCESS_TOKEN&" +
            "openid=OPENID&" +
            "lang=zh_CN";

    /**
     * 认证action
     */
    @Override
    public String execute() throws Exception {
            if(SignUtil.checkSignature(signature, timestamp, nonce)){
                try {
                    ServletActionContext.getResponse().getWriter().write(echostr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

    /**
     * 授权
     * @return
     */
    public String auto(){
        //获取code
        try {
            get_access_token_url=get_access_token_url.replace("CODE", code);
            //获取token and openid
            String json = HttpUtil.getUrl(get_access_token_url);
            JSONObject jsonObject = JSONObject.fromObject(json);
            String access_token = jsonObject.getString("access_token");
            openid = jsonObject.getString("openid");
            System.out.println(openid);
            //判断该用户的openid是否存在，如果不存保存该用户信息
            if(!userService.openidIsExist(openid)){
                //获取用户信息
                get_userinfo = get_userinfo.replace("ACCESS_TOKEN", access_token);
                get_userinfo = get_userinfo.replace("OPENID", openid);

                String userInfoJson=HttpUtil.getUrl(get_userinfo);

                JSONObject userInfoJO=JSONObject.fromObject(userInfoJson);
                User userInfo = new User();
                userInfo.setOpenid(userInfoJO.getString("openid"));
                userInfo.setNickname(userInfoJO.getString("nickname"));
                userInfo.setSex(Integer.parseInt(userInfoJO.getString("sex")));
                userInfo.setProvince(userInfoJO.getString("province"));
                userInfo.setHeadimgurl(userInfoJO.getString("headimgurl"));

                userInfo.setUserId(UUID.randomUUID().toString().replace("-",""));

                Cart cart = new Cart();
                cart.setCartId(userInfo.getUserId());
                //保存用户信息
                userService.saveOrUpdate(userInfo);
                userService.saveCart(cart);
                user = userInfo;
            }else{
                //再查询该用户信息
                user = userService.findByOpenid(openid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }




    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getNonce() {
            return nonce;
        }

        public void setNonce(String nonce) {
            this.nonce = nonce;
        }

        public String getEchostr() {
            return echostr;
        }

        public void setEchostr(String echostr) {
            this.echostr = echostr;
        }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGet_access_token_url() {
        return get_access_token_url;
    }

    public void setGet_access_token_url(String get_access_token_url) {
        this.get_access_token_url = get_access_token_url;
    }

    public String getGet_userinfo() {
        return get_userinfo;
    }

    public void setGet_userinfo(String get_userinfo) {
        this.get_userinfo = get_userinfo;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public String getAPPID() {
        return APPID;
    }

    public String getSECRET() {
        return SECRET;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
