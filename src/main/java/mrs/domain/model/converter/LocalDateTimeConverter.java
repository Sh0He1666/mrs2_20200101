//-------------------------------------------
//20191229 s.toku
//-------------------------------------------
package mrs.domain.model.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * LocalDateTimeをJAPで対応できるようデータを変換するクラスです
 * @author shoheitokumaru
 *memo:
 *LocalDateTime
 * ∟ LocalDate
 * ∟ LocalTime
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
	
	//Entity -> Database
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime dateTime) {
		return dateTime == null ? null : Timestamp.valueOf(dateTime);
	}
	
	//Database -> Entity
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp value) {
		return value == null ? null : value.toLocalDateTime();
	}
}
