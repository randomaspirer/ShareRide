package edu.nwmissouri.shareride;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by S525339 on 3/2/2016.
 */
public class RideCollection{
    public static ArrayList<Ride> items = new ArrayList<Ride>();
    private RideOfferAdapter mListAdapter;

    public RideCollection()
    {
       // items.add(new Ride("St. Louis Park","Nicollet mall",4));
        //items.add(new Ride("St. Louis Park", "Duluth", 2));
        //items.add(new Ride("Duluth", "Tofte", 2));
    }

    public ArrayList<Ride> getRideCollection()
    {
        return items;
    }

    public void addRideCollection(int OfferId,String fromAddress, String toAddress, String availability, String timeOftravel, String frequency)
    {
        items.add(new Ride(OfferId,fromAddress, toAddress, availability, timeOftravel, frequency));
//        mListAdapter.notifyDataSetChanged();
    }

    public int getMaxOfferId()
    {
        int maxId = 0;
        for(int i =0; i<items.size();i++)
        {
            if(items.get(i) != null)
            {
                if(items.get(i).getOfferID() > maxId)
                {
                    maxId = items.get(i).getOfferID();
                }
            }
        }
        return maxId;
    }

    public Ride getRideObject(int OfferId)
    {
        Ride resultObject = null;
        for(Ride item: items)
        {
            if(item.getOfferID() == OfferId)
            {
                resultObject =  item;
            }
        }

        return resultObject;
    }

    public boolean setRideObject(String resultOfferId, String fromAddressET,String toAddressET, String availabilityET, String hrsSpinner,String frequencySpinner)
    {
        Ride resultObject = null;
        for(Ride item: items)
        {
            if(item.getOfferID() == Integer.parseInt(resultOfferId))
            {
                item.setRouteFrom(fromAddressET);
                item.setRouteTo(toAddressET);
                item.setNoOfAvailability(availabilityET);
                item.setTimeOfTravel(hrsSpinner);
                item.setFrequency(frequencySpinner);

                return true;
            }
        }

        return false;
    }


}
