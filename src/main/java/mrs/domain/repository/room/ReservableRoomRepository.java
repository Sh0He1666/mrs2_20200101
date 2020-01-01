//-------------------------------------------
//20191229 s.toku
//-------------------------------------------
package mrs.domain.repository.room;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;

/**
 * ReservableRoomエンティティ用のリポジトリです。
 * @author shoheitokumaru
 *
 */
//引数はReservableRoomクラス, 主キークラスのReservableRoomId
public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {
	
	/* 悲観的ロックをかける
	 * 参考：https://qiita.com/NagaokaKenichi/items/73040df85b7bd4e9ecfc */
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	ReservableRoom findOneForUpdateByReservableRoomId(ReservableRoomId reservableRoomId);
	
	/*指定日に予約可能な会議室一覧を取得するメソッドを定義
	 * メソッド名の命名規則は以下
	 * findBy + ReservableRoomId.reservedDate + OrderBy + ReservableRoomId.roomId + Asc
	 */
	@Query("select distinct x from ReservableRoom x left join fetch x.meetingRoom"
			+ " where x.reservableRoomId.reservedDate = :date order by x.reservableRoomId.roomId asc")
	List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(
			@Param("date") LocalDate reservedDate);
}
