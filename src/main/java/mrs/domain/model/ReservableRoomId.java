//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

/**
 * roomIdとreservedDateフィールドによる複合クラスです
 * @author shoheitokumaru
 *
 */
//複合クラスであることを示すアノテーション
@Embeddable
public class ReservableRoomId implements Serializable {
	
	private Integer roomId;
	
	private LocalDate reservedDate;

	public ReservableRoomId(Integer roomId, LocalDate reservedDate) {
		this.roomId=roomId;
		this.reservedDate=reservedDate;
	}
	
	public ReservableRoomId() {
	}
	
	@Override
	public int hashCode() {
		final int prime=31;
		int result=1;
		//?: 「条件式 ? 式1 : 式2」。条件式がtrueなら式1、falseなら式2 ex) >= 1 ? “真” : “偽”
		result = prime * result + ((reservedDate == null) ? 0 : reservedDate.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		return result; /* 0 or hash値 */
	}
	
	@Override
	public boolean equals(Object obj) {
		//このクラスとobjが同一のオブジェクトを示す場合はtrue
		if(this == obj) return true;
		if(obj == null) return false;
		
		//getClass() -> このObjectの実行時クラスを返します。
		if (getClass() != obj.getClass()) return false;
		ReservableRoomId other = (ReservableRoomId) obj;
		if (reservedDate == null) {
			if (other.reservedDate != null) return false;
		} else if (!reservedDate.equals(other.reservedDate)) 
			return false;
		if (roomId == null) {
			if (other.roomId != null) return false;
		} else if (!roomId.equals(other.roomId)) 
			return false;
		return true;
	}
	
	
	//Getter Setter
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId=roomId;
	}

	public LocalDate getReservedDate() {
		return reservedDate;
	}
	public void setReservedDate(LocalDate reservedDate) {
		this.reservedDate=reservedDate;
	}
}
