//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.domain.service.reservation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;
import mrs.domain.model.Reservation;
import mrs.domain.model.RoleName;
import mrs.domain.model.User;
import mrs.domain.repository.reservation.ReservationRepository;
import mrs.domain.repository.room.ReservableRoomRepository;
import mrs.domain.service.reservation.*;

/**
 * 指定日付の予約一覧取得処理を実装したビジネスロジッククラスです
 * @author shoheitokumaru
 *
 */
@Service
@Transactional
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	//予約処理するメソッド
	public Reservation reserve(Reservation reservation) {
		ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();
		//対象の部屋が予約可能かチェック
		ReservableRoom reservable = reservableRoomRepository.findOneForUpdateByReservableRoomId(reservableRoomId);
		if (reservable==null) {
			//例外処理
			throw new UnavailableReservationException("入力の日付・部屋の組み合わせは予約できません。");
		}
		//重複チェック -> trueの場合重複あり
		//TODO: lambda式について調査
		boolean overlap = reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId)
				.stream()
				.anyMatch(x -> x.overlap(reservation));
		if (overlap) {
			//例外処理
			throw new AlreadyReservedException("入力の時間帯はすでに予約済みです。");
		}
		//予約情報の登録
		reservationRepository.save(reservation);
		return reservation;		
	}
	
	//予約キャンセルするメソッド
	@PreAuthorize("hasRole('ADMIN') or #reservation.user.userId == principal.user.userId")
	public void cancel(@P("reservation") Reservation reservation) {
		reservationRepository.delete(reservation);
	}
	
	/*
	//予約キャンセルするメソッド
	public void cancel(Integer reservationId, User requestUser) {
		Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
		if (RoleName.ADMIN != requestUser.getRoleName() && 
				!Objects.equals(reservation.getUser().getUserId(), requestUser.getUserId())) {
			throw new AccessDeniedException("要求されたキャンセルは許可できません。");
		}
		reservationRepository.delete(reservation);
	}
	*/
	
	//リポジトリ記載のメソッド実行するだけなので、特にロジックの実装なし
	public List<Reservation> findReservations(ReservableRoomId reservableRoomId) {
		return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
	}

	public Reservation findOne(Integer reservationId) {
		return reservationRepository.findById(reservationId).orElse(null);
	}
}
