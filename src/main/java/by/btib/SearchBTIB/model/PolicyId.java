package by.btib.SearchBTIB.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PolicyId implements Serializable {
    @Column(name = "policy_num")
    private String policyNum;
    private String company;
}
