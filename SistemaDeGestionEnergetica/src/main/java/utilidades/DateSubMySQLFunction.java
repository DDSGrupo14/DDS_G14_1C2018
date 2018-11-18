package utilidades;

import org.hibernate.dialect.MySQL57Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class DateSubMySQLFunction extends MySQL57Dialect {

    //Metodo para que hibernate pueda restar dias a una fecha
    public DateSubMySQLFunction(){
        super();
        registerFunction("date_sub_days", new SQLFunctionTemplate(StandardBasicTypes.DATE
                ,"date_sub( ?1, interval ?2 month)"));
    }
}
