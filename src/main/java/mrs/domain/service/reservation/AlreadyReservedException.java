//-------------------------------------------
//20191229 s.toku
//-------------------------------------------
package mrs.domain.service.reservation;
/**
 * 入力された日付・部屋の組み合わせではすでに予約済み
 * @author shoheitokumaru
 *
 */
public class AlreadyReservedException extends RuntimeException {
	public AlreadyReservedException(String message) {	
		super(message);
	}
}
