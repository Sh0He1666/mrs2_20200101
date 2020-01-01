//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.domain.model.converter;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * LocalTimeをJAPで対応できるようデータを変換するクラスです
 * @author shoheitokumaru
 *
 */
@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {
	
	//Entity -> Database
	@Override
	public Time convertToDatabaseColumn(LocalTime time) {
		return time == null ? null : Time.valueOf(time);
	}

	//Database -> Entity
	@Override
	public LocalTime convertToEntityAttribute(Time value) {
		return value == null ? null : value.toLocalTime();
	}
}
