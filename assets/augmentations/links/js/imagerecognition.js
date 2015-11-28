var World = {
	loaded: false,

	init: function initFn() {
		this.createOverlays();
	},

	createOverlays: function createOverlaysFn() {

		// alert('before load tracker');

		this.tracker = new AR.Tracker("links.wtc", {
			onLoaded: this.worldLoaded
		});

		// alert('after load tracker');

		/*
			The button is created similar to the overlay feature. An AR.ImageResource defines the look of the button and is reused for both buttons.
		*/

		// alert('before load image');

		this.emailButton = new AR.ImageResource("email.png");
		this.telephoneButton = new AR.ImageResource("telephone.png")

		// alert('after load image');

		/*
			The next step is to create the augmentation. In this example an image resource is created and passed to the AR.Imagedrawables. A drawables is a visual component that can be connected to an IR target (AR.Trackable2DObject) or a geolocated object (AR.GeoObject). The AR.Imagedrawables is initialized by the image and its size. Optional parameters allow for position it relative to the recognized target.
		*/

		/*
			For each target an AR.Imagedrawables for the button is created by utilizing the helper function createWwwButton(url, options). The returned drawables is then added to the drawabless.cam array on creation of the AR.Trackable2DObject.
		*/
		var leeFEmail = this.createWwwButton("http://52.26.245.70/projects/ar/forward.html?link=mailto:lee_h@utpb.edu", 0.1, {
			offsetX: -0.35,
			offsetY: -0.15,
			zOrder: 1
		}, this.emailButton);

		var leeFTel = this.createWwwButton("http://52.26.245.70/projects/ar/forward.html?link=tel:4325522551", 0.1, {
			offsetX: -0.35,
			offsetY: -0.35,
			zOrder: 1
		}, this.telephoneButton);

		var leeMEmail = this.createWwwButton("http://52.26.245.70/projects/ar/forward.html?link=mailto:lee_i@utpb.edu", 0.1, {
			offsetX: -0.35,
			offsetY: -0.2,
			zOrder: 1
		}, this.emailButton);

		var leeMTel = this.createWwwButton("http://52.26.245.70/projects/ar/forward.html?link=tel:4325522252", 0.1, {
			offsetX: -0.35,
			offsetY: -0.35,
			zOrder: 1
		}, this.telephoneButton);

		var vladVEmail = this.createWwwButton("http://52.26.245.70/projects/ar/forward.html?link=mailto:vuckovic@utpb.edu", 0.1, {
			offsetX: -0.35,
			offsetY: -0.15,
			zOrder: 1
		}, this.emailButton);

		var vladVTel = this.createWwwButton("http://52.26.245.70/projects/ar/forward.html?link=tel:4325522257", 0.1, {
			offsetX: -0.35,
			offsetY: -0.35,
			zOrder: 1
		}, this.telephoneButton);

		var yuanQEmail = this.createWwwButton("http://52.26.245.70/projects/ar/forward.html?link=mailto:yuan_q@utpb.edu", 0.1, {
			offsetX: -0.35,
			offsetY: -0.15,
			zOrder: 1
		}, this.emailButton);

		var yuanQTel = this.createWwwButton("http://52.26.245.70/projects/ar/forward.html?link=tel:4325522258", 0.1, {
			offsetX: -0.35,
			offsetY: -0.35,
			zOrder: 1
		}, this.telephoneButton);

		var leeF = new AR.Trackable2DObject(this.tracker, "lee-f", {
			drawables: {
				cam: [leeFTel, leeFEmail]
			}
		});

		var leeM = new AR.Trackable2DObject(this.tracker, "lee-m", {
			drawables: {
				cam: [leeMTel, leeMEmail]
			}
			// onEnterFieldOfVision: function(){
			// 	alert('entered');
			// }
		});
		var vladV = new AR.Trackable2DObject(this.tracker, "vlad", {
			drawables: {
				cam: [vladVTel, vladVEmail]
			}
		});

		var yuanQ = new AR.Trackable2DObject(this.tracker, "yuan", {
			drawables: {
				cam: [yuanQTel, yuanQEmail]
			}
		});

	},

	createWwwButton: function createWwwButtonFn(url, size, options, button) {
		/*
			As the button should be clickable the onClick trigger is defined in the options passed to the AR.Imagedrawables. In general each drawables can be made clickable by defining its onClick trigger. The function assigned to the click trigger calls AR.context.openInBrowser with the specified URL, which opens the URL in the browser.
		*/
		options.onClick = function() {
			console.log('?');
			AR.context.openInBrowser(url); //this only works if something else is called before it, hence why that log is there. ???
		};
		return new AR.ImageDrawable(button, size, options);
	},

	worldLoaded: function worldLoadedFn() {
		
		// document.getElementById('loadingMessage').innerHTML = 'loading';
	

		// // Remove Scan target message after 10 sec.
		// setTimeout(function() {
		// 	var e = document.getElementById('loadingMessage');
		// 	e.parentElement.removeChild(e);
		// }, 10000);
	}
};

World.init();