# Android-Firebase-Authentication-Generator

## Generate project json file:
- [FirebaseDocumentation](https://firebase.google.com/docs/cloud-messaging/migrate-v1)
- First step is to get project json file and put it here `put your android.json path here !`
- To get json file go to you `FirebaseConsole` Project setting and select `Service accounts` section, 
then click `Generate new private key`; it will download a json file,
put it anywhere you feel comfortable and then get the file path and put it here `put your android.json path here !` in `Main.java` class.
- Then run the project, and it will print the `API_KEY`, copy the api key and go to `Postman` and select `Headers` and write the `Key` part `Authorization` and put the value `Bearer "API_KEY"` 

## Working with Postman
- [FirebaseDocumentation](https://firebase.google.com/docs/cloud-messaging/migrate-v1)
- Go to `FirebaseConsole` and select `General` section then copy your `Project ID` and add it to this URL:
  https://fcm.googleapis.com/v1/projects/PROJECT_ID/messages:send
- In `Headers` part add `Content-Type` key to value `application/json`
- In `Body` select `raw` and add your required json data in it **CAUTION:** Firebase Cloud Messaging (FCM) not supporting nested objects or arrays (like your "buttons" array) inside the data field. FCM data payload is essentially a flat key-value structure, so arrays or objects can’t be used directly.
- Here is some sample of body data:
```json
{
    "message": {
        "topic": "your application topic",
        "data": {
            "title": "Test",
            "body": "This is a body test",
            "image_url": "image_url_cdn",
            "deep_link": "scheme://host/",
            "buttons": "[{\"title\": \"Button1\", \"deep_link\": \"scheme://host/\"}, {\"title\": \"Button2\", \"deep_link\": \"scheme://host/\"}]"
        }
    }
}
```

```json
{
  "message": {
    "topic": "news",
    "notification": {
      "title": "Breaking News",
      "body": "New news story available."
    },
    "data": {
      "deep_link": "scheme://host/"
    }
  }
}
```