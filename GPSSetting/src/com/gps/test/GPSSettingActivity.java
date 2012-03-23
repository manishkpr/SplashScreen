package com.gps.test;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

public class GPSSettingActivity extends Activity implements LocationListener {
    /** Called when the activity is first created. */
	LocationManager locationManager;
    @Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        checkGPS();
    }
    private void checkGPS(){
    	 locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
         locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L,1.0f, this);
         boolean isGPS = locationManager.isProviderEnabled (LocationManager.GPS_PROVIDER);
         if(isGPS){
         	showToast("Gps On");
         }else{
         	
         	startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
         }
    }
    
    @Override
  	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
  		super.onActivityResult(requestCode, resultCode, data);
  		checkGPS();
    }
    
    private void showToast(String text) {
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);
        toast.show();
    }

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}
}