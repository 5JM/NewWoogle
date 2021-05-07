package com.jm5.woogle.addProduct

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.jm5.woogle.R
import com.jm5.woogle.data.IdolList as IdolList


class AutoCompleteAdapter(context: Context, idolList: List<IdolList>) : ArrayAdapter<IdolList>(context, 0, idolList)
, Filterable{
    var list : List<IdolList> = idolList
//    val suggestions: MutableList<IdolList> = mutableListOf()
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val convertView = LayoutInflater.from(context).inflate(R.layout.idol_lists, parent, false)
//        val textView = convertView.findViewById<TextView>(R.id.idol_team_name)
//        val imageView: ImageView? = convertView.findViewById(R.id.idol_img)
//
//        //getItem(position) 코드로 자동완성 될 아이템을 가져온다
//        val idolItem: IdolList? = getItem(position)
//        if (idolItem != null) {
//            textView!!.text = idolItem.idolTeamName
//            Glide.with(context)
//                .load(idolItem.idolImg)
//                .placeholder(R.drawable.woogle_logo_02)
//                .centerCrop()
//                .into(imageView!!)
//        }
//        return convertView
//    }
//
////    fun setSuggests(list: List<IdolList>) {
////        suggestions.clear()
////        suggestions.addAll(list)
////    }
////    override fun getItem(position: Int): IdolList? {
////        return suggestions[position]
////    }
//    override fun getFilter(): Filter {
//        return idolFilter
//    }
//    private val idolFilter: Filter = object : Filter() {
//        override fun performFiltering(constraint: CharSequence?): FilterResults {
//            val results = FilterResults()
////            setSuggests(list)
////            if(constraint!=null){
////
////                val filterPattern =
////                    constraint.toString().toLowerCase().trim { it <= ' ' }
////                for (item in list) {
////                    if (item.idolTeamName?.toLowerCase()!!.contains(filterPattern)) {
////                        suggestions.add(item)
////                    }
////                }
////            }
////            results.apply {
////                values = suggestions
////                count = suggestions.size
////
////            }
//            val suggestions: MutableList<IdolList> = ArrayList()
//            if (constraint == null) {
////                suggestions.addAll(list)
//                Log.e("auto1>>",suggestions.toString())
//            } else {
//                results.apply {
//                    values = suggestions
//                    count = suggestions.size
//                }
////                Log.e("auto2>>","${results.values}")
//                val filterPattern =
//                    constraint.toString().toLowerCase().trim { it <= ' ' }
//                for (item in list) {
//                    if (item.idolTeamName?.toLowerCase()!!.contains(filterPattern)) {
//                        suggestions.add(item)
//                        Log.e("auto2>>","${item}")
//                    }
//                }
////                results.values = suggestions
////                results.count = suggestions.size
//            }
//            results.values = suggestions
//            results.count = suggestions.size
//            return results
//        }
//
//        override fun publishResults(
//            constraint: CharSequence?,
//            results: FilterResults
//        ) {
//
//            if (results != null && results.count > 0) {
//                clear()
//                addAll(results.values as MutableList<IdolList>)
//                notifyDataSetChanged()
//            } else {
//                notifyDataSetInvalidated()
//            }
////            clear()
////            addAll(results.values as MutableList<IdolList>)
////            notifyDataSetChanged()
//        }
//
//        override fun convertResultToString(resultValue: Any): CharSequence? {
//            return (resultValue as IdolList).idolTeamName
//        }
//    }
}