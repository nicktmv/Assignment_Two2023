import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Inventory implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "inventory_id")
    private Integer inventoryId;
   
    @Column(name = "quantity_in_stock")
    private Integer quantityInStock;
   
    @Column(name = "quantity_reserved")
    private Integer quantityReserved;
   
    @Column(name = "reorder_point")
    private Integer reorderPoint;
   
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne
    @ToString.Exclude
    private Product productId;
    
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    @ManyToOne
    @ToString.Exclude
    private Supplier supplierId;

       
}