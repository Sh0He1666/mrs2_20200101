//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.domain.service.room;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mrs.domain.model.MeetingRoom;
import mrs.domain.model.ReservableRoom;
import mrs.domain.repository.room.MeetingRoomRepository;
import mrs.domain.repository.room.ReservableRoomRepository;

//ビジネスロジックであることを示すアノテーション
@Service
@Transactional
/**
 * 
 * @author shoheitokumaru
 *
 */
public class RoomService {
	
	//ReservableRoomRepositoryをインジェンクション
	@Autowired
	ReservableRoomRepository reservableRoomRepository;
	
	//ReservableRoomRepositoryメソッドをコール
	public List<ReservableRoom> findReservableRooms(LocalDate date) {
		return reservableRoomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
	}
	
	//MeetingRoomRepositoryをインジェンクション
	@Autowired
	MeetingRoomRepository meetingRoomRepository;
	public MeetingRoom findMeetingRoom(Integer roomId) {
		return meetingRoomRepository.findById(roomId).orElse(null);
	}
	
}
