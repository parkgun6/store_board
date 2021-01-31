package store.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

	private Long sno;
	private String name;
	private double lat,lng;
	private String menu;
	private Date regdate, updateDate ;
	

	
	
}
