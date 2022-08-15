package by.btib.SearchBTIB.repository;

import by.btib.SearchBTIB.model.Policy;
import by.btib.SearchBTIB.model.PolicyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, String> {
    /*@Query("from Policy where upper(insuredName) like upper(?1)")
    List<Policy> findByInsuredName(String name);
    @Query("from Policy where " +
            "dateDistr >= ?1 and dateDistr <= ?2 and " +
            "(" +
            "policyNum like upper(?3) or " +
            "insuredName like upper(?4) or " +
            "insuredId like upper(?5) or " +
            "vehSign like upper(?6) or " +
            "bodyNo like upper(?7)" +
            ")")
    List<Policy> findByParams(String dateDistr1, String dateDistr2, String policyNum, String insuredName,
                              String insuredId, String vehSign, String bodyNo);*/
    //List<Policy> findByStartDateBetween(String dateDistr1, String dateDistr2);
    //boolean existsByPolicyNum(String policyNum);
    List<Policy> findByPolicyNumLikeAndDateDistrBetween(String policyNum, LocalDate start, LocalDate end);
    List<Policy> findByInsuredNameLikeAndDateDistrBetween(String insuredName, LocalDate start, LocalDate end);
    List<Policy> findByInsuredIdLikeAndDateDistrBetween(String insuredId, LocalDate start, LocalDate end);
    List<Policy> findByVehSignLikeAndDateDistrBetween(String vehSign, LocalDate start, LocalDate end);
    List<Policy> findByBodyNoLikeAndDateDistrBetween(String bodyNo, LocalDate start, LocalDate end);
    boolean existsByPolicyNumLikeAndDateDistrBetween(String policyNum, LocalDate start, LocalDate end);
    boolean existsByInsuredNameLikeAndDateDistrBetween(String insuredName, LocalDate start, LocalDate end);
    boolean existsByInsuredIdLikeAndDateDistrBetween(String insuredId, LocalDate start, LocalDate end);
    boolean existsByVehSignLikeAndDateDistrBetween(String vehSign, LocalDate start, LocalDate end);
    boolean existsByBodyNoLikeAndDateDistrBetween(String bodyNo, LocalDate start, LocalDate end);


}