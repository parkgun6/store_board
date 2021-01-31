package review.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	private Long rno,sno,score;
	private String mid,text;
	private Date regdate, updateDate ;
}
