var project = {
    "id": 32154,
    "targetCollections": {
        "V2": {
            "targetCollectionUrl": "wtc/targetcollections_4.0.x.wtc"
        },
        "V3": {
            "targetCollectionUrl": "wtc/targetcollections_4.1.x.wtc"
        },
        "V1": {
            "targetCollectionUrl": "wtc/targetcollections_3.x.wtc"
        },
        "targetCollectionThumbnailUrl": "http://s3-eu-west-1.amazonaws.com/studio-live/720573/datasets/7004d379-5216-44ac-ace0-18d26f65e463/dataset_gallery.png"
    },
    "targetCollectionUrl": "wtc/targetcollections.wtc",
    "lastLocallyStored": "2015-10-13T18:58:20.420Z",
    "targets": [{
        "id": "0.3829901907593012",
        "augmentations": [{
            "id": "bp_aug_3065407",
            "scale": 12,
            // "scale": 1,
            "height": "",
            "rotation": 0,
            "zoom": 1,
            "name": "bp_aug_3065407",
            "width": 15,
            "rotationTilt": 0,
            "src": "augmentation/models/falcon1.wt3",
            "type": "Model",
            "rotationHeading": 0,
            "zOrder": 1500,
            "y": 31.65766086138341,
            "x": 40.583036448342014
        }],
        "active": true,
        "scaleFactor": 1.0009765625,
        "label": "falcon_vision_small",
        "zoomFactor": 89,
        "size": {
            "height": 803,
            "width": 1024
        }
    }]
};

// alert(project.targets[0].augmentations[0].scale);

if (__SDK.checkVersion({
        minSDKVersion: {
            ios: "3.2",
            android: "3.2"
        } /*, requiredFeatures: ["3d"]*/
    })) {
    var converter = new blueprint.Converter(null, {
        report: false
    });
    converter.convertProject(project);
}

// URL paramaters do not work with wikitude... 
// so now instead of dynamically changing the scale of the model
// i.e. loadAug('index.html?scale=12') or loadAug('index.html?scale=2')
// 
// we'll have to make 3 copies of the augmentation with just the scale for each model changed. 
// lame...  

function updateScaleDiv(){
    $('#scale').html('Scale: ' + project.targets[0].augmentations[0].scale);	
   // alert(project.targets[0].augmentations[0].scale);
}

function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
}
