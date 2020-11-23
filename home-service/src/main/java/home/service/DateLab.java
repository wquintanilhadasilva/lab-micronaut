import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class DateLab {
	
	static ZoneId UTC = ZoneId.of("UTC");
	
	public static void main(String[] args) {
		
		LocalDate startDate = LocalDate.of(2020, 12, 01);
		Instant ld = startDate.atStartOfDay(UTC).toInstant();
		System.out.println(ld);
		
		build(startDate, 5);
		
		buildEndDay(ld);
		
		System.out.println("Next Day");
//		build(startDate, 1);
		Instant i = buildNextDay(ld);
		System.out.println(i);
		System.out.println("-----------");
		
		System.out.println("Next Week");
//		build(startDate, 7);
		i = buildSemana(ld);
		System.out.println(i);
		System.out.println("-----------");
		
		System.out.println("Next Quarterly");
//		build(startDate, 15);
		i = buildQuinzena(ld);
		System.out.println(i);
		System.out.println("-----------");
		System.out.println("Next Month");
//		build(startDate, 15);
		i = buildMes(ld);
		System.out.println(i);
		System.out.println("-----------");
//		
//		ld = startDate.plusDays(1).atStartOfDay(UTC).toInstant();
//		System.out.println(ld);
//		ld = startDate.plusDays(1).atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);
//		System.out.println(ld);
//		System.out.println("Next Day");
	}
	
	private static void build(LocalDate startDate, int days) {
		Instant ld = startDate.plusDays(days).atStartOfDay(UTC).toInstant();
		System.out.println("Start:" + ld);
		ld = startDate.plusDays(days + 6).atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC);
		System.out.println("End:" + ld);
		System.out.println("-----------");
	}
	
	private static void buildEndDay(Instant date) {
		LocalDateTime ldt = LocalDateTime.ofInstant(date, UTC);
		ldt = ldt.with(LocalTime.MAX);
		System.out.println("Start:" + date);
		System.out.println("End:" + ldt);
		System.out.println("-----------");
		
	}
	
	private static Instant buildNextDay(Instant instant) {
		LocalDate ld = instant.atZone(UTC).toLocalDate(); 
		return ld.plusDays(1).atStartOfDay(UTC).toInstant(); // LocalDate.of(ld.getYear(), ld.getMonth(), 16);
	}
	
	private static Instant buildQuinzena(Instant instant) {
		
		LocalDate ld = instant.atZone(UTC).toLocalDate(); // LocalDate.from(instant);
		if(ld.getDayOfMonth() < 16){
			return ld.plusDays(16 - ld.getDayOfMonth()).atStartOfDay(UTC).toInstant(); // LocalDate.of(ld.getYear(), ld.getMonth(), 16);
		}else {
			ld = ld.plusMonths(1);
			ld = ld.withDayOfMonth(1);
			return ld.atStartOfDay(UTC).toInstant();
		}
		
		
	}
	
	private static Instant buildSemana(Instant instant) {
		
		DayOfWeek dw = instant.atZone(UTC).getDayOfWeek();
		
		int index = dw.getValue();
		index = 7- index;
		index = index == 0 ? 7 : index;
		
		LocalDate ld = instant.atZone(UTC).toLocalDate(); // LocalDate.from(instant);
		
		instant =  ld.plusDays(index).atStartOfDay(UTC).toInstant();
		
		return instant;
		
	}
	private static Instant buildMes(Instant instant) {
		
		LocalDate ld = instant.atZone(UTC).toLocalDate(); // LocalDate.from(instant);
        ld = ld.plusMonths(1);
        ld = ld.withDayOfMonth(1);
        return ld.atStartOfDay(UTC).toInstant();
		
	}
	
	

}
