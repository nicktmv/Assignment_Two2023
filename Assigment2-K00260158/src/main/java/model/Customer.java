package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    
    @Column(name = "first_name")
    private String firstName;
   
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
   
    @Column(name = "password")
    private String password;
   
    @Lob
    @Column(name = "address")
    private String address;
   
    @Column(name = "phone_number")
    private String phoneNumber;
   
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Column(name = "payment_info")
    private String paymentInfo;
   
    @Lob
    @Column(name = "size_preferences")
    private String sizePreferences;
    
    @Column(name = "vip_status")
    private String vipStatus;
    
    @Lob
    @Column(name = "communication_preferences")
    private String communicationPreferences;
   
    @Column(name = "dateJoined")
    @Temporal(TemporalType.DATE)
    private Date dateJoined;
   
    @Column(name = "city")
    private String city;
   
    @OneToMany(mappedBy = "customerId")
    @ToString.Exclude
    private List<Review> reviewList;
   
    @OneToMany(mappedBy = "customerId")
    @ToString.Exclude
    private List<Wishlist> wishlistList;
    
    @OneToMany(mappedBy = "customerId")
    @ToString.Exclude
    private List<Orders> ordersList;

}