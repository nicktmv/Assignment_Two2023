package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Supplier implements Serializable {


    @Id
    @Basic(optional = false)
    @Column(name = "supplier_id")
    private Integer supplierId;
   
    @Column(name = "supplier_name")
    private String supplierName;
    
    @Column(name = "contact_name")
    private String contactName;
    
    @Column(name = "contact_email")
    private String contactEmail;
    
    @Column(name = "contact_phone")
    private String contactPhone;
    
    @Lob
    @Column(name = "address")
    private String address;
    
    @Column(name = "website")
    private String website;
    
    @Lob
    @Column(name = "description")
    private String description;
    
    @OneToMany(mappedBy = "supplierId")
    @ToString.Exclude
    private List<Inventory> inventoryList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    @ToString.Exclude
    private List<Product> productList;
    
}