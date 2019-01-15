#pragma once

#include "../header/sort_items.hpp"
#include "../header/textbox_listener.hpp"
#include "../header/sort_order.hpp"

namespace textsort {

class SortItemsImpl : public SortItems {

public:
    SortItemsImpl(const std::shared_ptr<TextboxListener> & listener);
    virtual void sort(sort_order order, const ItemList & items) override;

private:
    std::shared_ptr<TextboxListener> m_listener;

};

}
