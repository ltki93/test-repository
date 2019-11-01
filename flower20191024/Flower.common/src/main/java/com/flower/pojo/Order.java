package com.flower.pojo;

import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
public class Order extends BasePojo{

	private static final long serialVersionUID = 6245317485492183727L;
	private Long id;
	private Long userId;
	private Long productId;
	private Long price;
	private Integer status;
	private String payType;
	private Long payMent;
	private String addr;
	private Date payed;
}
