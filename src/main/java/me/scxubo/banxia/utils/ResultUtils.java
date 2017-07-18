package me.scxubo.banxia.utils;

import me.scxubo.banxia.domain.Result;

import static me.scxubo.banxia.domain.ResultCode.FAIL;
import static me.scxubo.banxia.domain.ResultCode.SUCCESS;
import static me.scxubo.banxia.domain.ResultCode.UNAUTHORIZED;

public class ResultUtils {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode( SUCCESS );
        result.setMessage( "返回成功" );
        result.setData( object );
        return result;
    }

    public static Result success(){
        return success( null );
    }

    public static Result error(Object object,String msg){
        Result result = new Result();
        result.setCode( FAIL );
        result.setMessage( msg );
        result.setData( object );
        return result;
    }

    public static Result login(Object object,String msg){
        Result result = new Result();
        result.setCode( UNAUTHORIZED );
        result.setMessage( msg );
        result.setData( object );
        return result;
    }
}
