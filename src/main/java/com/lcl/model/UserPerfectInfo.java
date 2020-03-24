package com.lcl.model;



import java.util.Date;

/**
 * @author lcl
 * @date 2019/10/20 23:04
 * @Description
 */
//@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
public class UserPerfectInfo {

    private String username;    //用户名
    private String education;   //学历
    private int salary;      //月薪
    private float height;      //身高
    private float weight;      //体重
    private String liveCondition;   //居住环境
    private String job;         //工作职业
    private String zodiac;      //生肖
    private String constellation;//星座
    private String faith;       //信仰
    private String jobTime;     //工作休假情况
    private String marryPlan;     //结婚打算
    private String parentStatus;    //父母情况
    private String broAndSis;       //兄弟姐妹情况

    private String loveHistory; //恋爱史
    private Date birthday;   //出生日期

    private String name;    //用户姓名

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getLiveCondition() {
        return liveCondition;
    }

    public void setLiveCondition(String liveCondition) {
        this.liveCondition = liveCondition;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getZodiac() {
        return zodiac;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getFaith() {
        return faith;
    }

    public void setFaith(String faith) {
        this.faith = faith;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public String getLoveHistory() {
        return loveHistory;
    }

    public void setLoveHistory(String loveHistory) {
        this.loveHistory = loveHistory;
    }

    public String getMarryPlan() {
        return marryPlan;
    }

    public void setMarryPlan(String marryPlan) {
        this.marryPlan = marryPlan;
    }

    public String getParentStatus() {
        return parentStatus;
    }

    public void setParentStatus(String parentStatus) {
        this.parentStatus = parentStatus;
    }

    public String getBroAndSis() {
        return broAndSis;
    }

    public void setBroAndSis(String broAndSis) {
        this.broAndSis = broAndSis;
    }

    public UserPerfectInfo() {
    }

    public UserPerfectInfo(String username, String education, int salary, float height, float weight, String liveCondition, String job, String zodiac, String constellation, String faith, String jobTime, String marryPlan, String parentStatus, String broAndSis, String loveHistory, Date birthday,String name) {
        this.username = username;
        this.education = education;
        this.salary = salary;
        this.height = height;
        this.weight = weight;
        this.liveCondition = liveCondition;
        this.job = job;
        this.zodiac = zodiac;
        this.constellation = constellation;
        this.faith = faith;
        this.jobTime = jobTime;
        this.marryPlan = marryPlan;
        this.parentStatus = parentStatus;
        this.broAndSis = broAndSis;
        this.loveHistory = loveHistory;
        this.birthday = birthday;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserPerfectInfo{" +
                "username='" + username + '\'' +
                ", education='" + education + '\'' +
                ", salary=" + salary +
                ", height=" + height +
                ", weight=" + weight +
                ", liveCondition='" + liveCondition + '\'' +
                ", job='" + job + '\'' +
                ", zodiac='" + zodiac + '\'' +
                ", constellation='" + constellation + '\'' +
                ", faith='" + faith + '\'' +
                ", jobTime='" + jobTime + '\'' +
                ", marryPlan='" + marryPlan + '\'' +
                ", parentStatus='" + parentStatus + '\'' +
                ", broAndSis='" + broAndSis + '\'' +
                ", loveHistory='" + loveHistory + '\'' +
                ", birthday=" + birthday +
                ", name='" + name + '\'' +
                '}';
    }
}
