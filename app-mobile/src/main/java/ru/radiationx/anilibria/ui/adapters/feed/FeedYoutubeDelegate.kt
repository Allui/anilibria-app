package ru.radiationx.anilibria.ui.adapters.feed

import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.nostra13.universalimageloader.core.ImageLoader
import kotlinx.android.synthetic.main.item_feed_youtube.view.*
import ru.radiationx.anilibria.R
import ru.radiationx.anilibria.ui.adapters.FeedListItem
import ru.radiationx.anilibria.ui.adapters.FeedUpdateDataPayload
import ru.radiationx.anilibria.ui.adapters.ListItem
import ru.radiationx.anilibria.ui.common.adapters.AppAdapterDelegate
import ru.radiationx.anilibria.ui.common.adapters.OptimizeDelegate
import ru.radiationx.data.entity.app.youtube.YoutubeItem

/**
 * Created by radiationx on 13.01.18.
 */
class FeedYoutubeDelegate(
        private val clickListener: (YoutubeItem, View) -> Unit
) : AppAdapterDelegate<FeedListItem, ListItem, FeedYoutubeDelegate.ViewHolder>(
        R.layout.item_feed_youtube,
        { (it as? FeedListItem)?.item?.youtube != null },
        { ViewHolder(it, clickListener) }
), OptimizeDelegate {

    override fun getPoolSize(): Int = 5

    override fun bindData(item: FeedListItem, holder: ViewHolder) = holder.bind(item.item.youtube!!)

    override fun applyPayloads(item: FeedListItem, payloads: MutableList<Any>, holder: ViewHolder) {
        payloads.filterIsInstance<FeedUpdateDataPayload>().forEach {
            holder.updateItem(item.item.youtube!!)
        }
    }

    class ViewHolder(
            val view: View,
            private val clickListener: (YoutubeItem, View) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        private lateinit var currentItem: YoutubeItem

        init {
            itemView.run {
                setOnClickListener {
                    clickListener.invoke(currentItem, item_image)
                }
            }
        }

        fun bind(item: YoutubeItem) {
            currentItem = item
            view.apply {
                item_title.text = item.title

                item_views_count.text = item.views.toString()
                item_comments_count.text = item.comments.toString()

                ImageLoader.getInstance().displayImage(item.image, item_image)
                ViewCompat.setTransitionName(item_image, "${item.javaClass.simpleName}_${item.id}")
            }
        }

        fun updateItem(item: YoutubeItem) {
            currentItem = item
        }
    }
}