//-------------------------------------------
//20191228 s.toku
//-------------------------------------------
package mrs.domain.model.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * LocalDateをJAPで対応できるようデータを変換するクラスです
 * @author shoheitokumaru
 *
 */
//エンティティのLocalDate型フィールドに対してこのAttributeConverterが自動で適用される
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
	
	//Entity -> Database
	@Override
	public Date convertToDatabaseColumn(LocalDate date) {
		return date == null ? null : Date.valueOf(date);
	}
	
	//Database -> Entity
	@Override
	public LocalDate convertToEntityAttribute(Date value) {
		return value == null ? null : value.toLocalDate();
	}
}
