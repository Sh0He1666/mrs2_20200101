//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * MeetingRoomを作成するエンティティです
 * @author shoheitokumaru
 *
 */

@Entity
public class MeetingRoom implements Serializable{
	@Id
	//データベースのidentity列を利用して，プライマリキー値を生成します
	//簡単にいうと、勝手にID生成してくれる設定
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;
	
	private String roomName;
	
	
	//Getter Setter
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId=roomId;
	}
	
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName=roomName;
	}
	
}
