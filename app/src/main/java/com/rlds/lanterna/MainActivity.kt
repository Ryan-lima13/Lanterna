package com.rlds.lanterna

import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rlds.lanterna.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    private  var estado = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()
        binding.lanterna.setOnClickListener {
            if(!estado){
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_ligada)
                estado = true
                luzLanterna(estado)
            }else{
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_desligada)
                estado = false
                luzLanterna(estado)
            }
        }
    }
    private fun luzLanterna(estado:Boolean){
        val cameraManeger:CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        val cameraId:String?
        try {
            cameraId = cameraManeger.cameraIdList[0]
            cameraManeger.setTorchMode(cameraId,estado)

        }catch (e:Exception){

        }

    }
}