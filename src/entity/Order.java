package entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString(exclude = "orderDetails")
@Table(name = "`order`")
public class Order implements SuperEntity {

    @Id
    private String id;
    private Date date;

    @ManyToOne(cascade ={ CascadeType.PERSIST ,CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="customerId",referencedColumnName = "id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order",cascade = {CascadeType.PERSIST ,CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH})
    private
    List<OrderDetail> orderDetails =new ArrayList<>();

    public Order(String id, Date date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public Order(String id, Date date, Customer customer, List<OrderDetail> orderDetails) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        for (OrderDetail orderDetail : orderDetails) {
            orderDetail.setOrder(this);
        }
        this.orderDetails = orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        for (OrderDetail orderdetail : orderDetails) {
            orderdetail.setOrder(this);
        }
        this.orderDetails = orderDetails;
    }

    public Order(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        this.getOrderDetails().add(orderDetail);
    }
}
