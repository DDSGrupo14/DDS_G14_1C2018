package utilidades;

import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class DateSubMonthMySQLFunction extends MySQL57Dialect {

    //Metodo para que hibernate pueda restar meses a una fecha
    public DateSubMonthMySQLFunction(){
        super();
        registerFunction("date_sub_month", new SQLFunctionTemplate(StandardBasicTypes.DATE
                ,"date_sub( ?1, interval ?2 month)"));
    }
}
