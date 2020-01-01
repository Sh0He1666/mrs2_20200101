//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * 予約可能部屋情報を設定するエンティティです
 * @author shoheitokumaru
 *
 */

@Entity
public class ReservableRoom implements Serializable {
	//埋め込みクラスの複合プライマリキーであることを示すアノテーションです。
	@EmbeddedId
	private ReservableRoomId reservableRoomId;

	//多対１
	@ManyToOne
	//結合先テーブルのカラム名を指定するアノテーション
	//結合先テーブルのプライマリキーとなっているカラムを指定
	@JoinColumn(name="room_id", insertable=false, updatable=false)
	//
	@MapsId("roomId")
	private MeetingRoom meetingRoom;
	
	public ReservableRoom(ReservableRoomId reservableRoomId) {
		this.reservableRoomId=reservableRoomId;
	}
	
	public ReservableRoom(){	
	}
	
	//Getter Setter
	public ReservableRoomId getReservableRoomId() {
		return reservableRoomId;
	}
	public void setReservableRoomId(ReservableRoomId reservableRoomId) {
		this.reservableRoomId=reservableRoomId;
	}
	
	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}
	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom=meetingRoom;
	}
	
	
	
}
