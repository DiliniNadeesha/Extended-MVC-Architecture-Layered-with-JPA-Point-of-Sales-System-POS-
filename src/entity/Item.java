package entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Item implements SuperEntity {
    @Id
    private String code;
    private String description;
    //@Column(name = "unit_price")
    private BigDecimal unitPrice;
    //@Column(name = "qty_on_hand")
    private int qtyOnHand;

    //BiDirectional karoth pamani

//    @OneToMany(mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE})
//    private List<OrderDetail> orderDetails = new ArrayList<>();
//
//    public List<OrderDetail> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void addOrderDetail(OrderDetail orderDetail){
//        //   orderDetail.setItem(this);
//        this.getOrderDetails().add(orderDetail);
//
//    }

}
