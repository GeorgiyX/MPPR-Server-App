netsh wlan set hostednetwork mode=allow ssid="Toshiba-WIFI" key="12340000" keyUsage=persistent &
netsh wlan start hostednetwork &
venv\Scripts\activate &
python server.py