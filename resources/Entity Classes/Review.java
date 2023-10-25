import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "review_id")
    private Integer reviewId;
    
    @Column(name = "rating")
    private Integer rating;
    
    @Lob
    @Column(name = "review_text")
    private String reviewText;
    
    @Column(name = "review_date")
    @Temporal(TemporalType.DATE)
    private Date reviewDate;
    
    @Column(name = "flagged_as_spam")
    private Boolean flaggedAsSpam;
    
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    @ToString.Exclude
    private Customer customerId;
    
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    @ToString.Exclude
    private Product productId;

}