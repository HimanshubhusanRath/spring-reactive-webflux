# Video Streaming using Reactive Programming

### NOTE: Check under the `Network` tab in the browser.
* Initially the video is loaded partially (e.g. only 10 seconds out of the 300 seconds of video).
When we try to fast forward / select a position in the video which is not yet loaded, a call happens to the server to fetch some more content of the video.
* This partial fetching is done by sending the `range` header (kind of an off-set) in the API call to the backend. Based on this range, the appropriate chunks of the video is returned in the response. 

