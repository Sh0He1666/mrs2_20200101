//-------------------------------------------
//20191229 s.toku
//-------------------------------------------
package mrs.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.*;

/**
 * Reservationエンティティを生成するクラスです
 * @author shoheitokumaru
 *
 */
@Entity
public class Reservation implements Serializable{
	@Id
	//主キーをJPAに自動採番させる
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reservationId;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	/* 多対１ReservableRoomエンティティと一方向の多対１の関連設定 */
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "reserved_date"),
				@JoinColumn(name = "room_id")})
	private ReservableRoom reservableRoom;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public boolean overlap(Reservation target) {
		//２つの予約の日付・部屋が別であれば重複なし -> false
		if (!Objects.equals(reservableRoom.getReservableRoomId(), target.reservableRoom.getReservableRoomId())) {
			return false;
		}
		//２つの予約の開始時刻と終了時刻が一致である場合は重複あり -> true
		if (startTime.equals(target.startTime) && endTime.equals(target.endTime)) {
			return true;
		}
		//２つの予約の開始時刻と終了時刻が交差しているか、または包含関係にあるか返す
		return target.endTime.isAfter(startTime) && endTime.isAfter(target.startTime);
	}
	
	//Getter Setter
	public Integer getReservationId() {
		return reservationId;
	}
	public void setRoomId(Integer reservationId) {
		this.reservationId=reservationId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime=startTime;
	}	
	
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime=endTime;
	}	
	
	public ReservableRoom getReservableRoom() {
		return reservableRoom;
	}
	public void setReservableRoom(ReservableRoom reservableRoom) {
		this.reservableRoom=reservableRoom;
	}	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user=user;
	}	
	
}
