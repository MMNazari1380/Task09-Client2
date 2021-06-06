package com.company;

// ketabkhane ha
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author MMNazari1380
 * @version 1.0
 */
public class Client
{

    /**
     * methode run baraye ejraye barname
     */
    public void run()
    {

        try
        {

            // sakhte shey baraye daryafte vorrodi
            Scanner sc = new Scanner(System.in);
            System.out.println(" lotfan shomare port ra vared konid");
            int port = sc.nextInt();
            Socket socket = new Socket( InetAddress.getLocalHost(), port );
            DataInputStream dataInputStream = new DataInputStream( socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // halghe baraye daryafte string ha az karbar va ersal be Server
            while(true)
            {

                System.out.println(" lotfan reshte ra vared konid ");
                String name = sc.next();
                String x = "over";
                dataOutputStream.writeUTF(name);
                String str = dataInputStream.readUTF();
                System.out.println(str);
                if(name.equals(x))
                    break;

            }

            // baraye daryafte kole ersali ha az Server
            String w =dataInputStream.readUTF();
            System.out.println(w);
            String ww =dataInputStream.readUTF();
            System.out.println(ww);
            // bastane socket va stream ha
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

        }
        // residegi be exception
        catch (IOException e)
        {

            e.printStackTrace();

        }

    }

}
