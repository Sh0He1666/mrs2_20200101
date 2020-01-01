//-------------------------------------------
//20191229 s.toku
//-------------------------------------------
package mrs.domain.service.reservation;
/**
 * 入力された日付・部屋の組み合わせでは予約できない
 * @author shoheitokumaru
 *
 */
public class UnavailableReservationException extends RuntimeException {
	public UnavailableReservationException(String message) {	
		super(message);
	}
}
