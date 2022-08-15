package by.btib.SearchBTIB.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "mvd00001")
public class Policy {
    /*@EmbeddedId
    private PolicyId id;*/
    @Id
    @Column(name = "policy_num")
    private String policyNum;
    private String company;
    private String ncompany;
    /*@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_distr")
    private Date dateDistr;*/
    @Column(name = "date_distr")
    private LocalDate dateDistr;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_beg")
    private Date dateBeg;
    @Column(name = "time_beg")
    private String timeBeg;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_end")
    private Date dateEnd;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_term")
    private Date dateTerm;
    @Column(name = "insured_id_no")
    private String insuredId;
    @Column(name = "insured_name")
    private String insuredName;
    @Column(name = "insured_address")
    private String insuredAddress;
    @Column(name = "body_no")
    private String bodyNo;
    @Column(name = "veh_type")
    private String vehType;
    @Column(name = "veh_passport")
    private String vehPassport;
    @Column(name = "veh_sign")
    private String vehSign;
    @Column(name = "veh_sign_rus")
    private String vehSignRus;

    public Policy() {
    }

    public Policy(String policyNum, String company, String ncompany, LocalDate dateDistr, Date dateBeg, String timeBeg, Date dateEnd, Date dateTerm, String insuredId, String insuredName, String insuredAddress, String bodyNo, String vehType, String vehPassport, String vehSign, String vehSignRus) {
        this.policyNum = policyNum;
        this.company = company;
        this.ncompany = ncompany;
        this.dateDistr = dateDistr;
        this.dateBeg = dateBeg;
        this.timeBeg = timeBeg;
        this.dateEnd = dateEnd;
        this.dateTerm = dateTerm;
        this.insuredId = insuredId;
        this.insuredName = insuredName;
        this.insuredAddress = insuredAddress;
        this.bodyNo = bodyNo;
        this.vehType = vehType;
        this.vehPassport = vehPassport;
        this.vehSign = vehSign;
        this.vehSignRus = vehSignRus;
    }

    /*public Policy(PolicyId id, String ncompany, Date dateDistr, Date dateBeg, Date timeBeg, Date dateTerm, String insuredId, String insuredName, String insuredAddress, String bodyNo, String vehType, String vehPassport, String vehSign, String vehSignRus) {
        this.id = id;
        this.ncompany = ncompany;
        this.dateDistr = dateDistr;
        this.dateBeg = dateBeg;
        this.timeBeg = timeBeg;
        this.dateTerm = dateTerm;
        this.insuredId = insuredId;
        this.insuredName = insuredName;
        this.insuredAddress = insuredAddress;
        this.bodyNo = bodyNo;
        this.vehType = vehType;
        this.vehPassport = vehPassport;
        this.vehSign = vehSign;
        this.vehSignRus = vehSignRus;
    }

    public PolicyId getId() {
        return id;
    }

    public void setId(PolicyId id) {
        this.id = id;
    }*/

    public String getPolicyNum() {
        return policyNum;
    }

    public void setPolicyNum(String policyNum) {
        this.policyNum = policyNum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNcompany() {
        return ncompany;
    }

    public void setNcompany(String ncompany) {
        this.ncompany = ncompany;
    }

    public LocalDate getDateDistr() {
        return dateDistr;
    }

    public void setDateDistr(LocalDate dateDistr) {
        this.dateDistr = dateDistr;
    }

    public Date getDateBeg() {
        return dateBeg;
    }

    public void setDateBeg(Date dateBeg) {
        this.dateBeg = dateBeg;
    }

    public String getTimeBeg() {
        return timeBeg;
    }

    public void setTimeBeg(String timeBeg) {
        this.timeBeg = timeBeg;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateTerm() {
        return dateTerm;
    }

    public void setDateTerm(Date dateTerm) {
        this.dateTerm = dateTerm;
    }

    public String getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(String insuredId) {
        this.insuredId = insuredId;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredAddress() {
        return insuredAddress;
    }

    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress;
    }

    public String getBodyNo() {
        return bodyNo;
    }

    public void setBodyNo(String bodyNo) {
        this.bodyNo = bodyNo;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getVehPassport() {
        return vehPassport;
    }

    public void setVehPassport(String vehPassport) {
        this.vehPassport = vehPassport;
    }

    public String getVehSign() {
        return vehSign;
    }

    public void setVehSign(String vehSign) {
        this.vehSign = vehSign;
    }

    public String getVehSignRus() {
        return vehSignRus;
    }

    public void setVehSignRus(String vehSignRus) {
        this.vehSignRus = vehSignRus;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNum='" + policyNum + '\'' +
                ", company='" + company + '\'' +
                ", ncompany='" + ncompany + '\'' +
                ", dateDistr=" + dateDistr +
                ", dateBeg=" + dateBeg +
                ", timeBeg=" + timeBeg +
                ", dateEnd=" + dateEnd +
                ", dateTerm=" + dateTerm +
                ", insuredId='" + insuredId + '\'' +
                ", insuredName='" + insuredName + '\'' +
                ", insuredAddress='" + insuredAddress + '\'' +
                ", bodyNo='" + bodyNo + '\'' +
                ", vehType='" + vehType + '\'' +
                ", vehPassport='" + vehPassport + '\'' +
                ", vehSign='" + vehSign + '\'' +
                ", vehSignRus='" + vehSignRus + '\'' +
                '}';
    }
}
