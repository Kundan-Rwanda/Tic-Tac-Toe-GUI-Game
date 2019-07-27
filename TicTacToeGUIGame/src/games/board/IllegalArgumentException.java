/*
Author: Kundan Kumar
About Author: Founder & CEO of Let's Code Bootcamp
Web: https://www.letscodebootcamp.com
Email: info@letscodebootcamp.com  or kundan.kumar011@gmail.com
Created on: 25/07/2019
 */
package games.board;

// IllegalArgementException Class to handle the Set Method

public class IllegalArgumentException extends Exception
{
    private final String exceptionmsg;
    public IllegalArgumentException(String errmsg)
   {
      exceptionmsg=errmsg;
   }
   public String getIllegalArgumentExceptionMessage()
   {
       return exceptionmsg;
   }
}
