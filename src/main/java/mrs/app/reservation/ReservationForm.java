//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.app.reservation;

import java.io.Serializable;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 予約登録フォームを表現するフォームオブジェクトです。
 * @author shoheitokumaru
 *
 */
@EndTimeMustBeAfterStartTime(message="終了時刻は開始時刻より後にしてください")
public class ReservationForm implements Serializable {
	//messageはエラー時のメッセージ
	@NotNull(message="必須です")
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime startTime;
	
	@NotNull(message="必須です")
	@ThirtyMinutesUnit(message="30分単位で入力してください")
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime endTime;
	
	
	// Getter Setter
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
}
