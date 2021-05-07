package com.jm5.woogle

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.jm5.woogle.data.IdolList
import kotlinx.android.synthetic.main.activity_add_product.*


class AddProductActivity : AppCompatActivity() {
    var idolList = ArrayList<IdolList>()
    private val GET_GALLERY_IMAGE = 200
    private val imageview: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

//        initList()
        val autoCompleteTextView: AutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.starName_autoComplete)
//        autoCompleteTextView.adapter = AutoCompleteAdapter(this, idolList)
        val adapter = ArrayAdapter<String>(this,R.layout.idol_lists,R.id.idol_team_name,resources.getStringArray(R.array.idols))
//        val adapter = AutoCompleteAdapter(this, idolList)
        autoCompleteTextView.setAdapter(adapter)

        val categoryAdapter = ArrayAdapter(this, R.layout.idol_lists,R.id.idol_team_name,resources.getStringArray(R.array.category))
        category_spinner.adapter = categoryAdapter
        category_spinner.setSelection(resources.getStringArray(R.array.category).size-1)

        add_img1.setOnClickListener {
           getGallery()
        }
        add_img2.setOnClickListener {
          getGallery()
        }
        add_img3.setOnClickListener {
            getGallery()
        }
        add_img4.setOnClickListener {
            getGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == GET_GALLERY_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
//        val selectedImageUri: Uri? = data.data
//        imageview!!.setImageURI(selectedImageUri);
//    }
        if(requestCode == 101 && resultCode == RESULT_OK) {
//            InputStream
            val it = contentResolver.openInputStream(data?.data!!)
//            Bitmap
            val bm = BitmapFactory.decodeStream(it);
            it?.close()
            add_img1.setImageBitmap(bm);

        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
       //권한을 허용 했을 경우
         if(requestCode == 1){
             val length = permissions.size
             for (i in 0..length) {
                 if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                     // 동의
                      Log.d("test?>","권한 허용 : " + permissions[i]);
                 }
             }
         }


    }

    //keyboard focus 조절
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val focusView: View? = currentFocus
        if (focusView != null) {
            val rect = Rect()
            focusView.getGlobalVisibleRect(rect)
            val x = ev!!.x.toInt()
            val y = ev!!.y.toInt()
            if (!rect.contains(x, y)) {
                val imm: InputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                if (imm != null) imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0)
                focusView.clearFocus()
            }
        }
        return super.dispatchTouchEvent(ev)
    }

    fun initList(){
//        idolList.add("엑소")
        idolList.add(IdolList("https://www.vhv.rs/dpng/d/451-4512697_-hd-png-download.png","Twice"))
//        idolList.add(IdolList("https://www.vhv.rs/dpng/d/451-4512697_-hd-png-download.png","트와이스"))
        idolList.add(IdolList("https://platum.kr/wp-content/uploads/2019/06/big-hit-entertainment-bts.png","BTS"))
//        idolList.add(IdolList("https://platum.kr/wp-content/uploads/2019/06/big-hit-entertainment-bts.png","방탄소년단"))
        idolList.add(IdolList("https://w7.pngwing.com/pngs/912/977/png-transparent-red-velvet-russian-roulette-bad-boy-the-red-perfect-velvet-red-velvet-kpop-tshirt-friendship-team.png","RedVelvet"))
//        idolList.add("Itzy")
//        idolList.add("아이유")
//        idolList.add("아스트로")


    }
    private fun getGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*")
        startActivityForResult(intent, GET_GALLERY_IMAGE)
    }
    fun loadGallery(){
//        Intent intent = new Intent(); //기기 기본 갤러리 접근
        val intent = Intent()
        intent.type = MediaStore.Images.Media.CONTENT_TYPE //구글 갤러리 접근
//        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent,101)

    }
}