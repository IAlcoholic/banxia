package me.scxubo.banxia.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="user")
public class user implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "userid")
    private int  userid;
//    '用户ID',
    @NotNull
    @Column(name = "user_name")
    private  String user_name ;
//    '用户名',
    @NotNull
    @Column(name = "user_pwd")
    private String user_pwd;
//    '用户密码',
@Column(name = "user_phone")
    private String user_phone;
//    '用户手机号码',
@Column(name = "user_sex")
    private String user_sex ;
//    '用户性别',
@Column(name = "user_qq")
    private String user_qq ;
//    '用户QQ号码',
@Column(name = "user_email")
    private String user_email;
//    '用户EMAIL地址',
@Column(name = "user_address")
    private String user_address ;
//    '用户地址',
@Column(name = "user_last_login_ip")
    private String user_last_login_ip ;
//    '用户上一次登录IP地址',
@Column(name = "user_birthday")
    private Timestamp user_birthday ;
//    '用户生日',
@Column(name = "user_signature")
    private String user_signature ;
//    '自我描述',
@Column(name = "user_image_url")
    private String user_image_url ;
//    '用户头像存储路径',
@Column(name = "user_register_time")
    private String user_register_time ;
//    '用户注册时间',
@Column(name = "user_register_ip")
    private String user_register_ip ;
//    '用户注册时IP地址',
@Column(name = "user_last_update_time")
    private String user_last_update_time;
//    '用户上次更新博客时间',
@Column(name = "user_power")
    private String user_power;
//    '拥有权限',

    public user() {
    }

    public user(String user_name, String user_pwd, String user_phone, String user_sex, String user_qq, String user_email, String user_address, String user_last_login_ip, Timestamp user_birthday, String user_signature, String user_image_url, String user_register_time, String user_register_ip, String user_last_update_time, String user_power) {
        this.user_name = user_name;
        this.user_pwd = user_pwd;
        this.user_phone = user_phone;
        this.user_sex = user_sex;
        this.user_qq = user_qq;
        this.user_email = user_email;
        this.user_address = user_address;
        this.user_last_login_ip = user_last_login_ip;
        this.user_birthday = user_birthday;
        this.user_signature = user_signature;
        this.user_image_url = user_image_url;
        this.user_register_time = user_register_time;
        this.user_register_ip = user_register_ip;
        this.user_last_update_time = user_last_update_time;
        this.user_power = user_power;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int user_id) {
        this.userid = userid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_qq() {
        return user_qq;
    }

    public void setUser_qq(String user_qq) {
        this.user_qq = user_qq;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_last_login_ip() {
        return user_last_login_ip;
    }

    public void setUser_last_login_ip(String user_last_login_ip) {
        this.user_last_login_ip = user_last_login_ip;
    }

    public Timestamp getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Timestamp user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_signature() {
        return user_signature;
    }

    public void setUser_signature(String user_signature) {
        this.user_signature = user_signature;
    }

    public String getUser_image_url() {
        return user_image_url;
    }

    public void setUser_image_url(String user_image_url) {
        this.user_image_url = user_image_url;
    }

    public String getUser_register_time() {
        return user_register_time;
    }

    public void setUser_register_time(String user_register_time) {
        this.user_register_time = user_register_time;
    }

    public String getUser_register_ip() {
        return user_register_ip;
    }

    public void setUser_register_ip(String user_register_ip) {
        this.user_register_ip = user_register_ip;
    }

    public String getUser_last_update_time() {
        return user_last_update_time;
    }

    public void setUser_last_update_time(String user_last_update_time) {
        this.user_last_update_time = user_last_update_time;
    }

    public String getUser_power() {
        return user_power;
    }

    public void setUser_power(String user_power) {
        this.user_power = user_power;
    }
}