package guru.springframework.msscbrewery.web.mappers;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

@Component
public class DateMapper {

	public OffsetDateTime asOffsetDateTime(Timestamp ts) {
		if (ts != null) {
			return OffsetDateTime.ofInstant(ts.toInstant(), ZoneOffset.UTC);
		} else {
			return null;
		}
	}

	public Timestamp asTimestamp(OffsetDateTime val) {
		if (val != null) {
			return Timestamp.valueOf(val.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
		} else {
			return null;
		}
	}
}
